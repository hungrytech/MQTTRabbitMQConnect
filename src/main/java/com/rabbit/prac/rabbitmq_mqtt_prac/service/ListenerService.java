package com.rabbit.prac.rabbitmq_mqtt_prac.service;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class ListenerService {
    private static final String QUEUE_NAME = "rabbit_queue";

    @RabbitListener(queues = QUEUE_NAME)
    public void listenMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        log.info("event message -> {}", message);
        channel.basicAck(tag, false);
    }
}
