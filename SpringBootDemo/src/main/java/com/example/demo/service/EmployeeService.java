package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.dao.NewEmployeeDao;
import com.example.demo.entities.EmployeeInfo;

@Service
public class EmployeeService {

	private NewEmployeeDao employeeDao;
	
	//列出所有员工信息
	public List<EmployeeInfo> listAllUser()
    {
        return employeeDao.findAll();
    }

	public EmployeeInfo saveOrUpdate(EmployeeInfo employeeInfo) {
		return employeeDao.save(employeeInfo);
	}
	
	public List<EmployeeInfo> get(Integer id) {
		List<EmployeeInfo> list = employeeDao.findAllById(id);
		return list;
	}
	
	public void deleteById(Integer Id){
		employeeDao.deleteById(Id);
//		EmployeeInfo employeeInfo = employeeDao.getOne(Id);
//		employeeInfo.setDeleted(true);
//        gcUserJPA.save(gcUser);
    }
}
