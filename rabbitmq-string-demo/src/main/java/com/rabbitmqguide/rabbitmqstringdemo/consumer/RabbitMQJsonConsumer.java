package com.rabbitmqguide.rabbitmqstringdemo.consumer;


import com.rabbitmqguide.rabbitmqstringdemo.dtos.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @RabbitListener(queues ="json-queue")
    public void consumeJsonMessage(User user) {
        logger.info("Received Json message: {}", user);
    }
}
