package com.example.employee;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.example.employee.enteties.departement;
import com.example.employee.repos.deptrepository;

@ContextConfiguration
@SpringBootTest
class deptApplicationTests {

	@Autowired
	private deptrepository departementRepository;
	
	@Test
	//ajout
	public void testCreatedepartement() {
	departement dept = new departement(0, "b", null);
	departementRepository.save(dept);
	}
	//find by id  1L :id =1 et long 
	@Test
	public void testFinddept()
	{
		departement d = departementRepository.findById(2L).get();
	System.out.println(d);
	}
	@Test
	public void testUpdatedept()
	{
		departement d = departementRepository.findById(2L).get();
	d.setNomDept("d");
	departementRepository.save(d);

	System.out.println(d);
	}
	@Test
	public void testDeletdept()
	{
	departementRepository.deleteById(3L);
		
	}
	@Test
	public void testFindAlldept()
	{
	   List<departement> depts= departementRepository.findAll();
		for(departement d:depts)
			System.out.println(d);
	}

	

}
