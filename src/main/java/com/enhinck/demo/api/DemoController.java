package com.enhinck.demo.api;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	/**
	 * 测试
	 *
	 * @param name
	 * @return
	 */
	@ApiOperation("测试")
	@PostMapping(value = "/test")
	public String login(String name) {

		return demoService.doDemo(name).getReturnObject();
	}

}
