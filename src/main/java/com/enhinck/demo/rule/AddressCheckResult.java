package com.enhinck.demo.rule;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressCheckResult {
	 private boolean postCodeResult = false; // true:通过校验；false：未通过校验
}
