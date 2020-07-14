package com.stackfortech.redispubsub.controller;

import com.stackfortech.redispubsub.configuration.RedisMessagePublisher;
import com.stackfortech.redispubsub.configuration.RedisMessageSubscriber;
import com.stackfortech.redispubsub.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/redis")
public class RedisController {

    private static Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisMessagePublisher messagePublisher;


    @PostMapping("/publish")
    public void publish(@RequestBody Message message) {
        logger.info(">> publishing : {}", message);
        messagePublisher.publish(message.toString());
    }

    @GetMapping("/subscribe")
    public List<String> getMessages(){
        return RedisMessageSubscriber.messageList;
    }

}


