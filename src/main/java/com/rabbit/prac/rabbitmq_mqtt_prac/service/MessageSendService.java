package com.rabbit.prac.rabbitmq_mqtt_prac.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class MessageSendService {

    private final RabbitTemplate rabbitTemplate;

    public void send(String message, String topic) {
        rabbitTemplate.send("amq.topic", topic, new Message(message.getBytes(StandardCharsets.UTF_8)));
    }
}
