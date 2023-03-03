package com.example.employee.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.example.employee.enteties.contrat;
import com.example.employee.enteties.departement;




public interface contratservice  {
	ResponseEntity<Object> saveContrat(contrat c,long id,long idemp);
	
	  
	    void deletContratbyid(Long id);
	    public contrat getContrat(Long id);
	    List<contrat>getallContrats();
	    Page<contrat>getallcontrats(int page ,int size);
	  
	    Page<contrat>findByKeyword(String Keyword,int page ,int size);
		ResponseEntity<Object> updateContrat(long id, contrat c,long idtype,long idemp);

}
