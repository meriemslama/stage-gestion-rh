package com.example.employee.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.employee.enteties.typecongee;



public interface typecongeeservice  {
	ResponseEntity<Object> saveTypeCongee(typecongee tc);
	
	  
	    void delettypeCongeebyid(Long id);
	    public typecongee gettypeCongee(Long id);
	    List<typecongee>getalltypescongees();
		ResponseEntity<Object> updateTypeCongee(long id, typecongee tc);

}
