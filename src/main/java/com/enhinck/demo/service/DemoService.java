package com.enhinck.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.service.remote.result.CallRemoteResult;

@FeignClient(value = "resource-server")
@Service
public interface DemoService {

	@PostMapping("/rest/demo/do")
	CallRemoteResult<String> doDemo(@RequestParam("name") String name);

}
