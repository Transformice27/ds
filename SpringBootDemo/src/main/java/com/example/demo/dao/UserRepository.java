package com.example.demo.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.UserInfo;


public interface UserRepository extends
			JpaRepository<UserInfo,Long>,
			JpaSpecificationExecutor<UserInfo>,
			Serializable
{
	UserInfo findByUsername(String username);
}

