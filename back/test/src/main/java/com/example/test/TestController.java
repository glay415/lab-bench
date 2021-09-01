package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private SimpMessagingTemplate webSocket;

    @MessageMapping("/sendTo")
    @SendTo("/topic/sendTo")
    public String SendToMessage() throws Exception {
        return "SendTo";
    }

    @MessageMapping("/Template")
    public void SendTemplateMessage() {
        webSocket.convertAndSend("/topics/template", "Template");
    }

    @RequestMapping(value = "/api")
    public void SendApi() {
        webSocket.convertAndSend("/topics/api", "API");
    }


}
