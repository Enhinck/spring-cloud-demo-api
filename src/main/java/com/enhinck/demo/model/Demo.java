package com.enhinck.demo.model;

import com.alibaba.fastjson.JSONObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Demo {
	private String title;
	private String message;

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}

}
