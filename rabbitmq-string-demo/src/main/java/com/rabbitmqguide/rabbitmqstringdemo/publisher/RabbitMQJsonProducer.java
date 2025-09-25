package com.rabbitmqguide.rabbitmqstringdemo.publisher;

import com.rabbitmqguide.rabbitmqstringdemo.dtos.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.json.key}")
    private String routingKey;

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user){
        logger.info("Sending message: {}", user.toString());
        rabbitTemplate.convertAndSend(exchangeName, routingKey, user);
    }
}
