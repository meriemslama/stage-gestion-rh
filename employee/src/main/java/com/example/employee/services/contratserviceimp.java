package com.example.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ResponseStatusException;

import com.example.employee.enteties.contrat;
import com.example.employee.repos.contratrepository;

import jakarta.transaction.Transactional;


@Service
public class contratserviceimp implements contratservice{

	@Autowired
   contratrepository contratrepository;
	@Override
	@CrossOrigin
	@Transactional
	public ResponseEntity<Object> saveContrat(contrat c) {
		// TODO Auto-generated method stub
		contratrepository
        .findById(c.getId())
        .ifPresentOrElse(
                dept -> {
                    throw new ResponseStatusException(HttpStatus.FOUND, "contrat ID alredy exist");
                }, () -> {
                	contratrepository.save(c);
                }
        );
		  return ResponseEntity.ok(c);
	}
	@Override
	public contrat getContrat(Long id) {
		// TODO Auto-generated method stub
		return  contratrepository.findById(id).get();
	}

	@Override
	@Transactional
	public ResponseEntity<Object> updateContrat(long id, contrat c) {
		// TODO Auto-generated method stub
		 contratrepository
         .findById(id)
         .ifPresentOrElse(cont -> {
        	 cont.setDateDebut(c.getDateDebut());
        	 cont.setDateFin(c.getDateFin());
        	 cont.setEmployees(c.getEmployees());
        	 cont.setTypecontrat(c.getTypecontrat());
        	
        	 contratrepository.save(cont);
         }, () -> {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "contrat to update not found");
         });
		 // return ResponseEntity.accepted().body("Successfully updated acte");
		 return ResponseEntity.ok(c);	}

	@Override
	@Transactional
	


	public void deletContratbyid(Long id) {
		// TODO Auto-generated method stub
		 contratrepository
         .findById(id)
         .ifPresentOrElse(cont -> {
        	 contratrepository.delete(cont);
         }, () -> {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "contrat to delete not found");
         });	

		
	}

	

	@Override
	public List<contrat> getallContrats() {
		//List<departement>departements=new ArrayList<>();
		return contratrepository.findAll();
		// return departements;
	}
	

}
