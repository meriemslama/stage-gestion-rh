package com.example.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ResponseStatusException;

import com.example.employee.enteties.departement;
import com.example.employee.repos.deptrepository;

import jakarta.transaction.Transactional;


@Service
public class deptserviceimpl implements deptservice{

	@Autowired
   deptrepository departementrepository;
	@Override
	@CrossOrigin
	@Transactional
	public ResponseEntity<Object> saveDepartement(departement d) {
		// TODO Auto-generated method stub
		departementrepository
        .findById(d.getIdDept())
        .ifPresentOrElse(
                dept -> {
                    throw new ResponseStatusException(HttpStatus.FOUND, "dept ID alredy exist");
                }, () -> {
                	departementrepository.save(d);
                }
        );
		  return ResponseEntity.ok(d);
	}
	@Override
	public departement getDepartement(Long id) {
		// TODO Auto-generated method stub
		return  departementrepository.findById(id).get();
	}

	@Override
	@Transactional
	public ResponseEntity<Object> updateDepartement(long id, departement d) {
		// TODO Auto-generated method stub
		 departementrepository
         .findById(id)
         .ifPresentOrElse(dept -> {
        	 dept.setNomDept(d.getNomDept());
        	 dept.setEmployees(d.getEmployees());
        	
             departementrepository.save(dept);
         }, () -> {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "dept to update not found");
         });
		 // return ResponseEntity.accepted().body("Successfully updated acte");
		 return ResponseEntity.ok(d);	}

	@Override
	@Transactional
	


	public void deletDepartementbyid(Long id) {
		// TODO Auto-generated method stub
		 departementrepository
         .findById(id)
         .ifPresentOrElse(dept -> {
        	 departementrepository.delete(dept);
         }, () -> {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "dept to delete not found");
         });	

		
	}

	

	@Override
	public List<departement> getallDepartements() {
		//List<departement>departements=new ArrayList<>();
		return departementrepository.findAll();
		// return departements;
	}
	

}
