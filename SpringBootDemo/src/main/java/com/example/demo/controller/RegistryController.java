package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.UserService;
import com.example.demo.entities.UserInfo;

@Controller
public class RegistryController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/registry")
	public String goRegistry() {
		return "registry";
	}
	
	@PostMapping(value="/user/registry")
	public String registry(
			@RequestParam("username") String username, 
			@RequestParam("password") String password,
			@RequestParam("email") String email,
			@RequestParam("phone") int phone,
			Map<String, Object> map,
			UserInfo userInfo,
			HttpSession session
			) {
		
		userInfo.setUsername(username);
		userInfo.setPassword(password);
		userInfo.setEmail(email);
		userInfo.setPhone(phone);
		
		userService.saveOrUpdate(userInfo);
		
		session.setAttribute("loginUser", username);
		return "redirect:/main.html";
	}
	
	
}
