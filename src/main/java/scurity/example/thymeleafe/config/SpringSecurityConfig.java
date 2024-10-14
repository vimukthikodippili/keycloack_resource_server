package scurity.example.thymeleafe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration

public class SpringSecurityConfig  {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authz) -> authz
//                        // Secure /admin path, requires authentication
//                        .requestMatchers("/welcome").authenticated()
//                        // Permit all other paths without authentication
//                        .anyRequest().permitAll()
//                )
//                // Enable HTTP Basic authentication
//                .httpBasic(withDefaults());
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated();

        http.oauth2ResourceServer().jwt();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }
}
