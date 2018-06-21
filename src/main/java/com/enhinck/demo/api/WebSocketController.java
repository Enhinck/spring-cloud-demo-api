package com.enhinck.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.extern.slf4j.Slf4j;
@Controller 
@CrossOrigin
@Slf4j
public class WebSocketController {
	public SimpMessagingTemplate template;

	@Autowired
	public WebSocketController(SimpMessagingTemplate template) {
		this.template = template;
	}

	@MessageMapping("/hello")
	@SendTo("/topic/hello")
	public Greeting greeting(Greeting message) throws Exception {
		return message;
	}

	@MessageMapping("/message")
	@SendToUser(value="/message",broadcast=true)
	public UserMessage userMessage(UserMessage userMessage) throws Exception {
		return userMessage;
	}
	
	@MessageMapping("/welcome")
	public String welcome(String userMessage) throws Exception {
		log.info(userMessage);
		return userMessage;
	}
	
	
}
