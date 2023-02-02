package com.example.employee.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.employee.enteties.contrat;




public interface contratservice  {
	ResponseEntity<Object> saveContrat(contrat c);
	
	  
	    void deletContratbyid(Long id);
	    public contrat getContrat(Long id);
	    List<contrat>getallContrats();
		ResponseEntity<Object> updateContrat(long id, contrat c);

}
