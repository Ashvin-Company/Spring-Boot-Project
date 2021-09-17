package com.barclays.rest.works.contracts;

import java.util.List;

import com.barclays.rest.works.entity.Employee;

public interface IEmployeeService {
	public Employee insertEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(int empId);
	public Employee updateEmployee(Employee employee);
	public String deleteEmployee(int empId);
	public List<Employee> getEmployeeByName(String name);
	public List<Employee> getEmployeeBySalary(int sal);
	public List<Employee> getEmployeeBetweenSalary(int sal1,int sal2);
	

}
