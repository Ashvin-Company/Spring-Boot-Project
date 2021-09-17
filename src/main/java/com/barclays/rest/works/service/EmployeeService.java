package com.barclays.rest.works.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.barclays.rest.works.contracts.IEmployeeService;
import com.barclays.rest.works.entity.Employee;
import com.barclays.rest.works.repo.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private EmployeeRepository repo;

	public Employee insertEmployee(Employee employee) {
			return repo.save(employee);
	}

	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}


	@Override
	public Employee getEmployeeById(int empId) {
		return repo.findById(empId).get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public String deleteEmployee(int empId) {
		Employee emp=repo.findById(empId).get();
		repo.delete(emp);
		return "Deleted";
		
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		return repo.getEmployeeByName(name);
	}

	@Override
	public List<Employee> getEmployeeBySalary(int sal) {
		
		return repo.getEmployeeBySalary(sal);
	}
	public List<Employee> getEmployeeBetweenSalary(int sal1,int sal2) {
		
		return repo.getEmployeeBetweenSalary(sal1,sal2);
	}
}
