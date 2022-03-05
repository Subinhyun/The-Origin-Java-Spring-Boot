package dev.hsooovn.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class KafkaMQ implements MesssageQueueInterface{
    private static final Logger logger = LoggerFactory.getLogger(KafkaMQ.class);
    public KafkaMQ(){
        logger.info("kafkamq component");
    }
    @Override
    public String readMessage(){
        // code for communicating with KafkaMQ
        return "message from KafkaMQ";
    }

}
