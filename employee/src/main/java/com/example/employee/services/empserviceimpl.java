package com.example.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ResponseStatusException;

import com.example.employee.enteties.departement;
import com.example.employee.enteties.employee;
import com.example.employee.repos.emprepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ManyToOne;
import jakarta.transaction.Transactional;
@Service

public class empserviceimpl implements empservice{
	@Autowired
     emprepository employeerepository;
	departement d;
	departement du;
	@Autowired
	deptservice dept;
	@Override
	
	@CrossOrigin
    @Transactional
    public ResponseEntity<Object> saveEmployee(employee newemp,long id) {
		d=dept.getDepartement( id);
        //emp.setDepartement(d);
        employeerepository
                .findById(newemp.getId())
                .ifPresentOrElse(
                	emp1 -> {
                            throw new ResponseStatusException(HttpStatus.FOUND, "emp ID alredy exist");
                        }, 
                	    () -> {
                            	
                            	newemp.setDepartement(d);
                               
                            	employeerepository.save(newemp);
                        	
                        }
                );
//        return ResponseEntity.accepted().body(acte);
        return ResponseEntity.ok(newemp);
    }
	@Override
	public employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		return employeerepository.findById(id).get();
	}

	@Override

	@Transactional
    public ResponseEntity<Object> updateEmployee(long id, employee newemp ,long iddept) {
		du=dept.getDepartement( iddept);
		newemp.setDepartement(du);
        employeerepository
                .findById(id)
                .ifPresentOrElse(emp -> {
                	emp.setNom(newemp.getNom());
                	emp.setPrenom(newemp.getPrenom());
                	emp.setCin(newemp.getCin());
                	emp.setPoste(newemp.getPoste());
                	emp.setDepartement(newemp.getDepartement());
                	emp.setGender(newemp.getGender());
                	emp.setAdresse(newemp.getAdresse());
                	emp.setCnss(newemp.getCnss());
                	emp.setDateembauche(newemp.getDateembauche());
                	emp.setDatenais(newemp.getDatenais());
                	emp.setEmail(newemp.getEmail());
                	emp.setImage(newemp.getImage());
                	emp.setTel(newemp.getTel());
                	emp.setVille(newemp.getVille());
                	emp.setSalary(newemp.getSalary());
                	
                
                   
                	employeerepository.save(emp);
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "emp to update not found");
                });
//        return ResponseEntity.accepted().body("Successfully updated acte");
        return ResponseEntity.ok(newemp);
    }

	

	@Override
	 @Transactional
	public void deletEmployeebyid(Long id) {
		// TODO Auto-generated method stub
		
		employeerepository
        .findById(id)
        .ifPresentOrElse(emp -> {
        	employeerepository.delete(emp);
        }, () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "emp to delete not found");
        });
		
	}



	@Override
	public Page<employee> getallEmployees(int page ,int size) {
		// TODO Auto-generated method stub
		//List<employee>employees=new ArrayList<>();
		Pageable pages=PageRequest.of(page, size);
		return employeerepository.findAll(pages);
		// return employees;
	}
	public List<employee> allEmployees() {
		// TODO Auto-generated method stub
		//List<employee>employees=new ArrayList<>();
		
		return employeerepository.findAll();
		// return employees;
	}
	public int femmeEmployee() {
		// TODO Auto-generated method stub
		//List<employee>employees=new ArrayList<>();
		
		return employeerepository.employeesfemme();
		// return employees;
	}
	public int hommeEmployee() {
		// TODO Auto-generated method stub
		//List<employee>employees=new ArrayList<>();
		
		return employeerepository.employeeshomme();
		// return employees;
	}
	@Override
	public Page<employee> findByKeyword( String Keyword, int page, int size) {
		Pageable pages=PageRequest.of(page, size);
		return employeerepository.findByKeyword(Keyword,pages);
	}

}
