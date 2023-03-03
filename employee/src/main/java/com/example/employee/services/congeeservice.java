package com.example.employee.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.example.employee.enteties.congee;
import com.example.employee.enteties.contrat;




public interface congeeservice  {
	ResponseEntity<Object> savecongee(congee c,long id,long idemp);
	
	  
	    void deletCongeebyid(Long id);
	    public congee getCongee(Long id);
	    List<congee>getallCongees();
	    Page<congee>getallcongee(int page ,int size);
		  
	    Page<congee>findByKeyword(String Keyword,int page ,int size);
		ResponseEntity<Object> updateCongee(long id, congee c,long idtype,long idemp);

}
