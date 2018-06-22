package com.enhinck.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.enhinck.demo.DemoApiApplication;
import com.enhinck.demo.rule.Address;
import com.enhinck.demo.rule.AddressCheckResult;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApiApplication.class)
@Slf4j
public class DroolsDemoApplicationTests {
	@Resource
	private KieSession kieSession;

	@Test
	public void contextLoads() {
		Address address = new Address();
		address.setPostcode("99425");

		AddressCheckResult result = new AddressCheckResult();
		kieSession.insert(address);
		kieSession.insert(result);
		int ruleFiredCount = kieSession.fireAllRules();

		log.info("触发了{}条规则", ruleFiredCount);
		if (result.isPostCodeResult()) {
			log.info("规则校验通过");
		}

	}

}
