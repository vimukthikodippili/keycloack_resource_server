package scurity.example.thymeleafe.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/token")
@CrossOrigin

public class TokenController {
    @GetMapping("/get-token")
    public Map<String,Object> getToken(@AuthenticationPrincipal Jwt jwt){

        return Collections.singletonMap("principle",jwt);
    }
}
