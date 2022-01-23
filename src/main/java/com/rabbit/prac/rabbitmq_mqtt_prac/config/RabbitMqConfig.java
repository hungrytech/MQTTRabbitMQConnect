package com.rabbit.prac.rabbitmq_mqtt_prac.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    private static final String QUEUE_NAME = "rabbit_queue";

    @Bean
    public Queue createQueue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public Binding createBindingBetweenQueueAndMqttTopic() {
        return new Binding(
                QUEUE_NAME,
                Binding.DestinationType.QUEUE,
                "amq.topic",
                "bindingKey",
                null);

    }
}
