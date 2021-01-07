package com.example.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
public class MainController {
	@ResponseBody //用于响应页面
	@RequestMapping("/hello")
	private String sayHello() {
		return "Hello";
	}
	
//	@RequestMapping({"/","/index.html"})
//	private String index() {
//		return "index";
//	}
	
	@RequestMapping("/success")
	//thymeleaf渲染success页面 此处不能用@RestController
	private String success(Map<String,Object> map) {
		map.put("hello","你好");
		return "success";
	}
}
