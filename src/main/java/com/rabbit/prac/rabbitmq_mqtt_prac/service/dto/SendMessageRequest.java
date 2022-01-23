package com.rabbit.prac.rabbitmq_mqtt_prac.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SendMessageRequest {

    private String message;

    private String topic;
}
