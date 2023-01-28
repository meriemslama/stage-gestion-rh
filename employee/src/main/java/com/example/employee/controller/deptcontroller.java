package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.enteties.departement;
import com.example.employee.services.deptservice;


@RestController
@RequestMapping("/departements")
public class deptcontroller {

	@Autowired
	private deptservice departementservice;

	public deptcontroller(deptservice departementservice) {
		super();
		this.departementservice = departementservice;
	}

	@GetMapping("/all")
    public List<departement> Alldepartements() {
        List<departement> depts = departementservice.getallDepartements();
        return depts;
    }
	/*@GetMapping("/departements/new")
	public String creatdepartementform(Model model){
		
		departement dept=new departement();
		model.addAttribute("departements",dept);
		return "create_departement";
		
	}*/
    @PostMapping("/add")
    public ResponseEntity<Object> adddept(@RequestBody departement dept) {
    return departementservice.saveDepartement(dept);
}
  /* @GetMapping("/departements/edit/{id}")
	public String editdepartementform(@PathVariable Long id , Model model){
		
		model.addAttribute("departement",departementservice.getDepartement(id));
		return "edit_departement";
		
	}*/
   
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateActe(@RequestBody departement dept, @PathVariable long id) {
        return departementservice.updateDepartement(id, dept);
    }
	

    @DeleteMapping("/delete/{id}")
    public void deleteActe(@PathVariable long id) {
      departementservice.deletDepartementbyid(id);
  }

  @GetMapping("/get/{id}")
  public departement findActe(@PathVariable long id) {
      return departementservice.getDepartement(id);
  }


}
