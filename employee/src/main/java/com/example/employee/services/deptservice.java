package com.example.employee.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.example.employee.enteties.departement;
import com.example.employee.enteties.employee;




//,long id
public interface deptservice  {
	ResponseEntity<Object> saveDepartement(departement d);
	
	  
	    void deletDepartementbyid(Long id);
	    public departement getDepartement(Long id);
	    Page<departement>getallDepartements(int page ,int size);
	    List<departement>allDepartements();
	    List<String> getAllDepartments();
	    Page<departement>findByKeyword(String Keyword,int page ,int size);
		ResponseEntity<Object> updateDepartement(long id, departement d);

}
