package com.microservice.publish.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.microservice.publish.model.MovieDetail;

@Service
public final class ConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "kafkaTopic", groupId = "group_id")
    public void consume(MovieDetail message) {
        logger.info(String.format("$$$$ => Consumed Movie title: %s", message.getTitle()));
		logger.info(String.format("$$$$ => Consumed Description: %s", message.getDescription()));
		logger.info(String.format("$$$$ => Consumed Type name: %s", message.getType()));
		logger.info(String.format("$$$$ => Consumed Rating: %s", message.getRating()));
		//store any DB if required
    }
}