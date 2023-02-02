package com.example.employee.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.employee.enteties.departement;





public interface deptservice  {
	ResponseEntity<Object> saveDepartement(departement d);
	
	  
	    void deletDepartementbyid(Long id);
	    public departement getDepartement(Long id);
	    List<departement>getallDepartements();
		ResponseEntity<Object> updateDepartement(long id, departement d);

}
