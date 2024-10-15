package scurity.example.thymeleafe.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping
public class TestController {
    @PreAuthorize("hasAnyRole('ROLE_developer')")
    @GetMapping(path = "/welcome")
    public String getWelcome(){
        return "welcome";

    }
    @GetMapping(path = "/notwelcome")
    public String getNotWelcome(){
        return "notwelcome";

    }
}
