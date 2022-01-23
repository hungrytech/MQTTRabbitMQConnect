package com.rabbit.prac.rabbitmq_mqtt_prac.controller;

import com.rabbit.prac.rabbitmq_mqtt_prac.service.MessageSendService;
import com.rabbit.prac.rabbitmq_mqtt_prac.service.dto.SendMessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SendMessageController {

    private final MessageSendService messageSendService;

    @PostMapping("/send-message")
    public ResponseEntity<String> sendMessage(@RequestBody SendMessageRequest sendMessageRequest) {
        messageSendService.send(sendMessageRequest.getMessage(), sendMessageRequest.getTopic());

        return ResponseEntity.ok(sendMessageRequest.getMessage());
    }
}
