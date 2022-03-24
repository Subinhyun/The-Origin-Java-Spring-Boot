package dev.hsooovn.producer.controller;

import dev.hsooovn.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProducerController {
    private final ProducerService producerService;

    public ProducerController(
            @Autowired ProducerService producerService
    ){
        this.producerService = producerService;
    }

    @GetMapping("/")
    public void sendMessage(){
        producerService.send();
    }
}
