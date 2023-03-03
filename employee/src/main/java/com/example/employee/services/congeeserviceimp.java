package com.example.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ResponseStatusException;

import com.example.employee.enteties.congee;
import com.example.employee.enteties.contrat;
import com.example.employee.enteties.departement;
import com.example.employee.enteties.typecongee;
import com.example.employee.repos.congeerepository;

import jakarta.transaction.Transactional;


@Service
public class congeeserviceimp implements congeeservice{

	@Autowired
   congeerepository congeerepository;
	typecongee t;
	typecongee tu;
	com.example.employee.enteties.employee employee;
	com.example.employee.enteties.employee employeeu;
	@Autowired
	typecongeeservice type;
	@Autowired
	empservice emp;
	@Override
	@CrossOrigin
	@Transactional
	public ResponseEntity<Object> savecongee(congee c,long id,long idemp) {
		// TODO Auto-generated method stub
		t=type.gettypeCongee( id);
		employee=emp.getEmployee(idemp);
		congeerepository
        .findById(c.getId())
        .ifPresentOrElse(
                dept -> {
                    throw new ResponseStatusException(HttpStatus.FOUND, "congee ID alredy exist");
                }, () -> {
                	c.setEmployee(employee);
                	c.setTypecongee(t);
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
	public ResponseEntity<Object> updateCongee(long id, congee c,long idtype,long idemp) {
		// TODO Auto-generated method stub
		tu=type.gettypeCongee( idtype);
		employeeu=emp.getEmployee( idemp);
		c.setEmployee(employeeu);
		c.setTypecongee(tu);
		 congeerepository
         .findById(id)
         .ifPresentOrElse(cong -> {
        	 cong.setDateDebut(c.getDateDebut());
        	 cong.setDateFin(c.getDateFin());
        	// cong.setEmployees(c.getEmployees());
        	 cong.setEmployee(c.getEmployee());
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
	@Override
	public Page<congee> getallcongee(int page ,int size) {
		//List<departement>departements=new ArrayList<>();
		Pageable pages=PageRequest.of(page, size);
		return congeerepository.findAll(pages);
		// return departements;
	}
	
	public Page<congee> findByKeyword( String Keyword, int page, int size) {
		Pageable pages=PageRequest.of(page, size);
		return congeerepository.findByKeyword(Keyword,pages);
	}
	

}
