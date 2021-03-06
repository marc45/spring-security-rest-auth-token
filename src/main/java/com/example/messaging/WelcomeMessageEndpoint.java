package com.example.messaging;

import com.example.messaging.dto.Message;
import com.example.messaging.dto.WelcomeMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.concurrent.TimeUnit;

@Controller
public class WelcomeMessageEndpoint {
    @MessageMapping("/ws/url/welcome")
    @SendTo("/ws/topic/welcome")
    public WelcomeMessage welcome(Message message) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return WelcomeMessage.of(message);
    }
}