package com.example.demo.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.example.demo.entities.EmployeeInfo;


public interface NewEmployeeDao extends
			JpaRepository<EmployeeInfo,Integer>,
			JpaSpecificationExecutor<EmployeeInfo>,
			Serializable
{
	EmployeeInfo findByUsername(String username);
	List<EmployeeInfo> findAllById(Integer id);
}
