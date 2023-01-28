package com.example.employee;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.example.employee.enteties.employee;
import com.example.employee.repos.emprepository;

@ContextConfiguration
@SpringBootTest
class EmployeeApplicationTests {
	@Autowired
	private emprepository employeeRepository;
	
	@Test
	//ajout
	public void testCreateemployee() {
	employee emp = new employee();
	employeeRepository.save(emp);
	}
	//find by id  1L :id =1 et long 
	@Test
	public void testFindemp()
	{
		employee p = employeeRepository.findById(1L).get();
	System.out.println(p);
	}
	@Test
	public void testUpdateemployee()
	{
		employee e = employeeRepository.findById(1L).get();
	e.setCin(2000);
	employeeRepository.save(e);

	System.out.println(e);
	}
	@Test
	public void testDeletemployee()
	{
		employeeRepository.deleteById(1L);
		
	}
	@Test
	public void testFindAllemployee()
	{
	   List<employee> emp= employeeRepository.findAll();
		for(employee e:emp)
			System.out.println(e);
	}

	 

}
