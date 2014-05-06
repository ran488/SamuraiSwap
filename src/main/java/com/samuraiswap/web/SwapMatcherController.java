package com.samuraiswap.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class SwapMatcherController {

	private static final String template = "Hello, %s! (%s)";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("hello")
	public @ResponseBody String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
		return String.format(template, name, counter.incrementAndGet());
	}

}