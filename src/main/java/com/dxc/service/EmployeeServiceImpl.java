package com.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.model.Employee;
import com.dxc.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	
	public Employee createEmp(Employee employee) {
		
		return repo.save(employee);
	}


	
	public List<Employee> getEmployees() {
		
		return repo.findAll();
	}



	
	public Employee getEmployee(int id) {
		
		return repo.findById(id).orElse(null);
	}



	
	public Employee updateEmployee(Employee employee, int id) {
		Employee oldEmpl = repo.findById(id).orElse(null);
		oldEmpl.setId(employee.getId());
		oldEmpl.setName(employee.getName());
		oldEmpl.setSalary(employee.getSalary());
		oldEmpl.setEmail(employee.getEmail());
		repo.save(oldEmpl);
		return oldEmpl;
	}



	@Override
	public void deleteEmployee(int id) {
		repo.deleteById(id);	
	}

}
