package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.enteties.employee;
import com.example.employee.services.empservice;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/employees")
public class empcontroller {
	@Autowired
	private empservice employeeservice;

	public empcontroller(empservice employeeservice) {
		super();
		this.employeeservice = employeeservice;
	}
	
	@GetMapping("/all")
	public List<employee> getallemployees(){
		//return produitservice.getallproduits();
		//model.addAttribute("listEmployees",employeeservice.getallEmployees());
		List<employee> emps = employeeservice.getallEmployees();
		return emps;
		
	}
	/*@GetMapping("/newemplform")
	public String createmployeeform(Model model){
		
		employee employee=new employee();
		model.addAttribute("employee",employee);
		return "new_employee";
		
	}*/
   @PostMapping("/add")
   public ResponseEntity<Object> addemp(@RequestBody employee emp) {
       return employeeservice.saveEmployee(emp);
	}
  /* @GetMapping("/employees/edit/{id}")
	public String editemployeeform(@PathVariable Long id , Model model){
		
		model.addAttribute("employee",employeeservice.getEmployee(id));
		return "edit_employee";
		
	}*/
   
   @PutMapping("/update/{id}")
   public ResponseEntity<Object> updateemp(@RequestBody employee emp, @PathVariable long id) {
       return employeeservice.updateEmployee(id, emp);
	}
	

   @DeleteMapping("/delete/{id}")
   public void deleteemp(@PathVariable long id) {
     employeeservice.deletEmployeebyid(id);
 }
   
   @GetMapping("/get/{id}")
   public employee findActe(@PathVariable long id) {
       return employeeservice.getEmployee(id);
   }
}



