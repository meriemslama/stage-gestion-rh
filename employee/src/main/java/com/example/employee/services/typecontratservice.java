package com.example.employee.services;

import java.util.List;

import org.springframework.http.ResponseEntity;



import com.example.employee.enteties.typecontrat;



public interface typecontratservice  {
	ResponseEntity<Object> saveTypeContrat(typecontrat tc);
	
	  
	    void delettypeContratbyid(Long id);
	    public typecontrat gettypeContrat(Long id);
	    List<typecontrat>getalltypescontrat();
		ResponseEntity<Object> updateTypeContrat(long id, typecontrat tc);

}
