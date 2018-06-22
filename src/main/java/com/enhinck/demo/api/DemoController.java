package com.enhinck.demo.api;

import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enhinck.demo.model.Demo;
import com.enhinck.demo.rabbmit.RabbitMQSender;
import com.enhinck.demo.service.DemoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/demo")
public class DemoController extends BaseController {

	protected static Logger logger = LoggerFactory.getLogger(DemoController.class);

	@Resource
	private RedisTemplate<String, String> redisTemplate;

	@Resource
	DemoService demoService;

	
	@Resource
	RabbitMQSender rabbitMQSender;
	
	@ApiOperation("测试")
	@PostMapping("/testRabbitMQ")
	public void test() {
		Demo message = new Demo();
		//greeting.setName("测试消息1" + Math.random()+"");
		//greeting.setValue(Math.random()+"");
		message.setTitle(UUID.randomUUID().toString().replaceAll("-", ""));
		message.setMessage("111111111111");
		rabbitMQSender.send(message);
	}
	/**
	 * 测试
	 *
	 * @param name
	 * @return
	 */
	@ApiOperation("测试")
	@PostMapping(value = "/test")
	@PreAuthorize("hasPermission('user','admin')")
	public String login(String name) {

		return demoService.doDemo(name).getReturnObject();
	}
	
    @Autowired
    WebSocketController webSocketController;
    @ApiOperation("测试WebSocket")
    @PreAuthorize("hasPermission('user','ROLE_ADMIN')")
    @RequestMapping(value = "test1", method = RequestMethod.POST)
    public void test(@RequestBody Greeting greeting) {
    	UserMessage userMessage = new UserMessage();
    	BeanUtils.copyProperties(greeting,userMessage);
    	webSocketController.template.convertAndSend("/topic/hello",greeting); //广播  
    	webSocketController.template.convertAndSendToUser("1", "/message",userMessage); //一对一发送，发送特定的客户端 
    }

}
