package dev.aquashdw.controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {
    private static final Logger logger
            = LoggerFactory.getLogger(SampleController.class);

    @GetMapping(
            value = "/hello"
    )
    public String hello(@RequestParam(
            name = "id", required = false, defaultValue = "") String id
    ){
        logger.info("Path: Hello");
        logger.info("Query Param id: " + id);
        return "/hello.html";
    }

    @GetMapping(
            value = "/hello/{id}"
    )
    public String helloPath(@PathVariable("id") String id){
        logger.info("Path Variable is: " + id);
        return "/hello.html";
    }

    @GetMapping(
            "/get-profile"
    )
    public @ResponseBody SamplePayload getProfile(){
        return new SamplePayload("hsooovn", 24, "Developer");
    }
}
