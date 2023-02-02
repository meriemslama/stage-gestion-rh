package com.example.employee.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.employee.enteties.congee;




public interface congeeservice  {
	ResponseEntity<Object> savecongee(congee c);
	
	  
	    void deletCongeebyid(Long id);
	    public congee getCongee(Long id);
	    List<congee>getallCongees();
		ResponseEntity<Object> updateCongee(long id, congee c);

}
