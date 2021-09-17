package com.barclays.rest.works.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.rest.works.entity.Employee;
import com.barclays.rest.works.contracts.IEmployeeService;

@RestController
public class EmployeeController{
	
	@Autowired
	private IEmployeeService service;
	@GetMapping("/")
	public String health()
	{
		return "Working..to check health";
	}

	@GetMapping("/sayhi/{name}")
	public String sayHi(@PathVariable("name") String name)
	{
		return name;
	}
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return service.getAllEmployee();
	}
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable("id") int id){
		return service.getEmployeeById(id);
	}
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee){
		return service.insertEmployee(employee);
	}
	@PutMapping("/employees/update")
	public Employee updateEmployee(@RequestBody Employee employee){
		return service.updateEmployee(employee);
	}
	@DeleteMapping("/employees/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id){
		return service.deleteEmployee(id);
	}
	@GetMapping("/employees/name/{n}")
	public List<Employee> getEmployeeByName(@PathVariable("n") String n){
		return service.getEmployeeByName(n);
	}
	@GetMapping("/employees/salary/{sal}")
	public List<Employee> getEmployeeBySalary(@PathVariable("sal") int sal){
		return service.getEmployeeBySalary(sal);
	}
	@GetMapping("/employees/salary/{sal1}/{sal2}")
	public List<Employee> getEmployeeBetweenSalary(@PathVariable("sal1") int sal1,@PathVariable("sal2") int sal2){
		return service.getEmployeeBetweenSalary(sal1,sal2);
	}
	
}