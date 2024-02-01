package me.ricky.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        return Optional.ofNullable((Map<String, Object>) jwt.getClaims().get("realm_access"))
                .map(realmAccess -> (Collection<String>) realmAccess.get("roles"))
                .orElse(Collections.emptyList())
                .stream()
                .map(roleName -> "ROLE_" + roleName)
                .map(roleName -> (GrantedAuthority) () -> roleName)
                .toList();
    }
}
