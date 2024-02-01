package me.ricky.proxy;

import me.ricky.aggregate.user.facade.dto.LoginQdo;
import me.ricky.aggregate.user.facade.dto.OneIdCdo;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.Optional;

public interface OneIdProxy {
    Optional<UserRepresentation> findBySub(String sub);

    boolean existsByUsername(String email);
    UserRepresentation createUser(OneIdCdo cdo);

    AccessTokenResponse signIn(LoginQdo loginQdo);
}
