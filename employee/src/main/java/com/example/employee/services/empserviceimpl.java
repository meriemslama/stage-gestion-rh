package com.example.employee.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ResponseStatusException;

import com.example.employee.enteties.employee;
import com.example.employee.repos.emprepository;

import jakarta.transaction.Transactional;
@Service

public class empserviceimpl implements empservice{
	@Autowired
     emprepository employeerepository;
	@Override
	
	@CrossOrigin
    @Transactional
    public ResponseEntity<Object> saveEmployee(employee emp) {

        employeerepository
                .findById(emp.getId())
                .ifPresentOrElse(
                        emp1 -> {
                            throw new ResponseStatusException(HttpStatus.FOUND, "emp ID alredy exist");
                        }, () -> {
                        	employeerepository.save(emp);
                        }
                );
//        return ResponseEntity.accepted().body(acte);
        return ResponseEntity.ok(emp);
    }
	@Override
	public employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		return employeerepository.findById(id).get();
	}

	@Override

	@Transactional
    public ResponseEntity<Object> updateEmployee(long id, employee newemp) {
        employeerepository
                .findById(id)
                .ifPresentOrElse(emp -> {
                	emp.setNom(newemp.getNom());
                	emp.setPrenom(newemp.getPrenom());
                	emp.setCin(newemp.getCin());
                	emp.setDepartement(newemp.getDepartement());
                   
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
	public List<employee> getallEmployees() {
		// TODO Auto-generated method stub
		//List<employee>employees=new ArrayList<>();
		return employeerepository.findAll();
		// return employees;
	}

}
