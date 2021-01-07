package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.UserInfo;
import com.example.demo.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/user/login")
//	@RequestMapping(value="/user/login", method=RequestMethod.POST) == PostMapping(value="/user/login")
	public String login(@RequestParam("username") String username, 
						@RequestParam("password") String password,
						Map<String, Object> map,
						HttpSession session) {
		
		
		UserInfo userInfo = userService.checkUser(username, password);
		System.out.println(userInfo);
        if (userInfo != null)
        {
        	session.setAttribute("loginUser", username);
			return "redirect:/main.html"; //redirect重定向到main.html 再由视图映射到dashboard
        } else
        {
        	map.put("msg", "用户名或密码错误");
			return "login";
        }
	}
}
