package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.UserInfo;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	//注册保存用户或更新
	public UserInfo saveOrUpdate(UserInfo userInfo) {
		return userRepository.save(userInfo);
	}
	
	public UserInfo checkUser(String userName,String passWord){
		UserInfo userInfo = userRepository.findByUsername(userName);
        if(userInfo!=null&&passWord.equals(userInfo.getPassword())){
            return userInfo;
        }else {
            return null;
        }
    }
}
