package me.ricky.config.keycloak;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;


import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
@Component
public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    @Value("${keycloak.client-id}")
    private String clientId;
    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        return Optional.ofNullable((Map<String, Object>) jwt.getClaims().get("resource_access"))
                .map(resourceAccess -> (Map<String, Object>) resourceAccess.get(clientId))
                .map(clientAccess -> (Collection<String>) clientAccess.get("roles"))
                .orElse(Collections.emptyList())
                .stream()
                .map(roleName -> "ROLE_" + roleName)
                .map(roleName -> (GrantedAuthority) () -> roleName)
                .toList();
    }
}
