package com.enhinck.demo.rabbmit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enhinck.demo.config.RabbitMQConfig;
import com.enhinck.demo.model.Demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void send(Demo message) {
		amqpTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "", message);
		log.info("exchange={}, routingkey ={},Send msg = {} ", RabbitMQConfig.EXCHANGE_NAME, "", message);
	}
}