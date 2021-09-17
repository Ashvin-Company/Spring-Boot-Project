package com.barclays.rest.works;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.barclays.rest.works.contracts.IEmployeeService;
import com.barclays.rest.works.entity.Employee;
import com.barclays.rest.works.repo.EmployeeRepository;

@SpringBootTest
class RestWorksApplicationTests {

	@MockBean
	private EmployeeRepository repo;
	
	@Autowired
	private IEmployeeService service;
	
	@Test
	void employeeInsertTest()
	{
		Employee employee=new Employee(101,"Ashvin",1234);
		when(repo.save(employee)).thenReturn(employee);
		assertEquals("Ashvin",service.insertEmployee(employee).getEmpName());
		assertEquals(true,true);
	}
	

}
