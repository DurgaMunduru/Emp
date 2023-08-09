package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.model.Employee;
import com.dxc.service.EmployeeService;


//in this controller we r going to rest api s
@RestController  
@RequestMapping("/emp")  //basemapping
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee emp) {
		return service.createEmp(emp);
	}
	
	@GetMapping("/getEmps")
	public List<Employee>getEmps(){
		return service.getEmployees();
	}
	
	@GetMapping("/getEmps/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return service.getEmployee(id);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable int id ,Employee employee) {
		return service.updateEmployee(employee, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteEmployee(@PathVariable int id){
		service.deleteEmployee(id);
		return new ResponseEntity<String>("Employee Deleted Succesfully",HttpStatus.OK);
	}
}
