package me.ricky.client;

import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ricky.aggregate.user.domain.enums.RoleType;
import me.ricky.aggregate.user.facade.dto.LoginQdo;
import me.ricky.aggregate.user.facade.dto.OneIdCdo;
import me.ricky.aggregate.user.facade.dto.OneIdQdo;
import me.ricky.proxy.OneIdProxy;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@ConditionalOnMissingBean(value = LocalOneIdConfig.class)
@RequiredArgsConstructor
@Component
public class OneIdClient implements OneIdProxy {
    @Value("${keycloak.auth-server-url}")
    private String authServerUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.client-id}")
    private String clientId;

    @Value("${keycloak.client-secret}")
    private String clientSecret;

    private final Keycloak keycloak;
    private final RealmResource realmResource;

    @Override
    public Optional<UserRepresentation> findBySub(String sub) {
        UserResource userResource = realmResource.users().get(sub);
        return userResource == null ? Optional.empty() : Optional.of(userResource.toRepresentation());
    }

    public UserRepresentation createUser(OneIdCdo cdo) {

        // 유저정보 세팅
        UserRepresentation oneIdUserRepresent = new UserRepresentation();
        oneIdUserRepresent.setEnabled(true);
        oneIdUserRepresent.setUsername(cdo.email());
        oneIdUserRepresent.setLastName(cdo.name());
        oneIdUserRepresent.setEmail(cdo.email());
        oneIdUserRepresent.setEmailVerified(true);

        // Get realm
        UsersResource usersResource = realmResource.users();

        Response response = usersResource.create(oneIdUserRepresent);
        if (response.getStatus() != 201) throw new RuntimeException("Failed to create user");

        String sub = CreatedResponseUtil.getCreatedId(response);
        UserResource userResource = usersResource.get(sub);
        createPasswordCredential(userResource, cdo.password());
        createRole(userResource, cdo.roleType());

        UserRepresentation createdUser = userResource.toRepresentation();
        return createdUser;
    }

    public void createRole(UserResource userResource, RoleType roleType) {
        ClientRepresentation clientRep = realmResource.clients().findByClientId(clientId).get(0);
        List<RoleRepresentation> list = realmResource.clients().get(clientRep.getId()).roles().list();
        RoleRepresentation clientRoleRep =
                realmResource.clients().get(clientRep.getId()).roles()
                        .get(roleType.name())
                        .toRepresentation();

        userResource.roles().clientLevel(clientRep.getId()).add(Collections.singletonList(clientRoleRep));
    }

    private void createPasswordCredential(UserResource userResource, String password) {
        // create password credential
        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(password);

        // Set password credential
        userResource.resetPassword(passwordCred);
    }

    public AccessTokenResponse signIn(LoginQdo loginQdo) {
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl(authServerUrl)
                .realm(realm)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .grantType(OAuth2Constants.PASSWORD)
                .username(loginQdo.email())
                .password(loginQdo.password())
                .build();

        AccessTokenResponse response = keycloak.tokenManager().getAccessToken();
        return response;
    }

    public boolean existsByUsername(String username) {
        List<UserRepresentation> search = realmResource.users()
                .search(username);
        if (!search.isEmpty()) {
            log.debug("search : {}", search.get(0).getUsername());
            return true;
        }
        return false;
    }

    public List<UserRepresentation> findAllUsers(OneIdQdo qdo) {
        UsersResource usersResource = realmResource.users();

        return usersResource.search(qdo.email());
    }
}
