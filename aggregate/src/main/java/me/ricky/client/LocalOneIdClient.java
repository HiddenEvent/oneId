package me.ricky.client;

import me.ricky.aggregate.user.facade.dto.LoginQdo;
import me.ricky.aggregate.user.facade.dto.OneIdCdo;
import me.ricky.proxy.OneIdProxy;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.util.Optional;

@ConditionalOnBean(value = LocalOneIdConfig.class)
@Component
public class LocalOneIdClient implements OneIdProxy {
    @Override
    public UserRepresentation findBySub(String sub) {
        return new UserRepresentation();
    }

    @Override
    public boolean existsByUsername(String email) {
        return false;
    }

    @Override
    public UserRepresentation createUser(OneIdCdo cdo) {
        return null;
    }

    @Override
    public AccessTokenResponse signIn(LoginQdo loginQdo) {
        return null;
    }
}
