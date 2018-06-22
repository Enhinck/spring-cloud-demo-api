package com.enhinck.demo.rabbmit;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.enhinck.demo.config.RabbitMQConfig;
import com.enhinck.demo.model.Demo;

import lombok.extern.slf4j.Slf4j;

@Service
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "", durable = "true", autoDelete = "true", exclusive = "true"), exchange = @Exchange(value = RabbitMQConfig.EXCHANGE_NAME, type = ExchangeTypes.FANOUT, durable = "true")))
@Slf4j
public class RabbitMQReceive {
	 
	@RabbitHandler
	public void process(Demo eventMessage) {
		log.info("Receiver  : {} ", eventMessage);
	}
}
