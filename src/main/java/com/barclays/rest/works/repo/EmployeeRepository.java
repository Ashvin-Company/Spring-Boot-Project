package com.barclays.rest.works.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.barclays.rest.works.entity.Employee;
public interface EmployeeRepository extends MongoRepository<Employee,Integer>{
	@Query("{empName:?0}")
	List<Employee> getEmployeeByName(String emp);
	@Query("{salary:{$gt:?0}}")
	List<Employee> getEmployeeBySalary(int salary);
	@Query("{$and:[{salary:{$gt:?0}},{salary:{$lt:?1}}]}")
	List<Employee> getEmployeeBetweenSalary(int sal1,int sal2);
		

}
