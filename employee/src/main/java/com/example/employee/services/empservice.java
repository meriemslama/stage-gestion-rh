package com.example.employee.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.employee.enteties.employee;




public interface empservice  {
	ResponseEntity<Object> saveEmployee(employee e);
	
	  
	    void deletEmployeebyid(Long id);
	    public employee getEmployee(Long id);
	    List<employee>getallEmployees();
		ResponseEntity<Object> updateEmployee(long id, employee newemp);
}
