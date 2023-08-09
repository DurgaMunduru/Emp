package com.dxc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.model.Employee;

@Service
public interface EmployeeService {
	
	public Employee createEmp(Employee employee);
	public List<Employee>getEmployees();
	public Employee getEmployee(int id);
	public Employee updateEmployee(Employee employee,int id);
	public void deleteEmployee(int id);
}
