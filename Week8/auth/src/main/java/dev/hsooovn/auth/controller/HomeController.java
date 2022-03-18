package dev.hsooovn.auth.controller;

import dev.hsooovn.auth.infra.AuthenticationFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Configuration
@RequestMapping("home")
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final AuthenticationFacade authenticationFacade;

    public HomeController(
            @Autowired AuthenticationFacade authenticationFacade) {
        this.authenticationFacade = authenticationFacade;
    }

    // 방법 1
//    @GetMapping
//    public String home(Principal principal){
//        try {
//            logger.info("connected user : {}", principal.getName());
//        } catch (NullPointerException e) {
//            logger.info("no user logged in");
//        }
//        return "index";
//    }

    // 방법 2
//    @GetMapping
//    public String home(Authentication authentication){
//        try {
//            logger.info("connected user: {}",authentication.getName());
//        } catch (NullPointerException e) {
//            logger.info("no user logged in");
//        }
//        return "index";
//    }

    // 방법 3
    @GetMapping
    public String home(){
        try {
            logger.info("connected user: {}", authenticationFacade.getUserName());
        } catch (NullPointerException e) {
            logger.info("no user logged in");
        }
        return "index";
    }
}
