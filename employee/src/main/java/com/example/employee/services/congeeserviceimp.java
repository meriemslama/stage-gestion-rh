package com.example.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ResponseStatusException;

import com.example.employee.enteties.congee;
import com.example.employee.repos.congeerepository;

import jakarta.transaction.Transactional;


@Service
public class congeeserviceimp implements congeeservice{

	@Autowired
   congeerepository congeerepository;
	@Override
	@CrossOrigin
	@Transactional
	public ResponseEntity<Object> savecongee(congee c) {
		// TODO Auto-generated method stub
		congeerepository
        .findById(c.getId())
        .ifPresentOrElse(
                dept -> {
                    throw new ResponseStatusException(HttpStatus.FOUND, "congee ID alredy exist");
                }, () -> {
                	congeerepository.save(c);
                }
        );
		  return ResponseEntity.ok(c);
	}
	@Override
	public congee getCongee(Long id) {
		// TODO Auto-generated method stub
		return  congeerepository.findById(id).get();
	}

	@Override
	@Transactional
	public ResponseEntity<Object> updateCongee(long id, congee c) {
		// TODO Auto-generated method stub
		 congeerepository
         .findById(id)
         .ifPresentOrElse(cong -> {
        	 cong.setDateDebut(c.getDateDebut());
        	 cong.setDateFin(c.getDateFin());
        	 cong.setEmployees(c.getEmployees());
        	 cong.setTypecongee(c.getTypecongee());
        	
        	 congeerepository.save(cong);
         }, () -> {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "congee to update not found");
         });
		 // return ResponseEntity.accepted().body("Successfully updated acte");
		 return ResponseEntity.ok(c);	}

	@Override
	@Transactional
	


	public void deletCongeebyid(Long id) {
		// TODO Auto-generated method stub
		 congeerepository
         .findById(id)
         .ifPresentOrElse(cong -> {
        	 congeerepository.delete(cong);
         }, () -> {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "congee to delete not found");
         });	

		
	}

	

	@Override
	public List<congee> getallCongees() {
		//List<departement>departements=new ArrayList<>();
		return congeerepository.findAll();
		// return departements;
	}
	

}
