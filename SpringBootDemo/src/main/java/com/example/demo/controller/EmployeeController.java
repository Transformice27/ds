package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import com.example.demo.entities.EmployeeInfo;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DepartmentDao departmentDao;
	
	//查询所员工返回列表
	@GetMapping("/emps")
	public String list(Model model) {
		//将dao层查找出来的所有员工放在collection集合里
		Collection<EmployeeInfo> employee = employeeService.listAllUser();
		
		//放进请求域
		model.addAttribute("emps", employee);
		
		return "emp/list"; 
	}
	
	//员工添加页面
	@GetMapping("/emp")
	public String toAddPage(Model model) {
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("depts", departments);
		return "emp/add";
	}
	
	@PostMapping("/emp")
	//springboot自动将请求对象和入参对象属性进行一一绑定,请求参数的名字和bean对象的属性名字一样
	public String addEmp(EmployeeInfo employee) {
		//redirect重定向
		//forward转发
		//保存添加的员工信息
		employeeService.saveOrUpdate(employee);
		return "redirect:/emps";
	}
	//查询修改的员工id
	@GetMapping("/emp/{id}")
	public String toEditPage(@PathVariable("id") Integer id, Model model) {
		EmployeeInfo employee = (EmployeeInfo) employeeService.get(id);
		model.addAttribute("emp", employee);
		
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("depts", departments);
		return "emp/add";
	}
	
	//修改员工
	@PutMapping("/emp")
	public String updateEmployee(EmployeeInfo employee) {
		employeeService.saveOrUpdate(employee);
		return "redirect:/emps";
	}
	
	@DeleteMapping("/emp/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.deleteById(id);
		return "redirect:/emps";
	}
}
