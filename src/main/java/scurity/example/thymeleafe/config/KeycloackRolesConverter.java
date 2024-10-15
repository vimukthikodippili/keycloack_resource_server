package scurity.example.thymeleafe.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeycloackRolesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {


    @Override
    public Converter andThen(Converter after) {
        return Converter.super.andThen(after);
    }

    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {
        // Extract realm access from the JWT claims
        Map<String, Object> realmAccess = (Map<String, Object>) source.getClaims().get("realm_access");
        if (realmAccess == null || realmAccess.isEmpty()) {
            return new ArrayList<>();
        }

        // Extract roles and convert them to GrantedAuthority objects
        List<String> roles = (List<String>) realmAccess.get("roles");
        if (roles == null || roles.isEmpty()) {
            return new ArrayList<>();
        }

        // Convert roles to GrantedAuthority and return the collection
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))  // Prepend "ROLE_" to each role name
                .collect(Collectors.toList());
    }
}
