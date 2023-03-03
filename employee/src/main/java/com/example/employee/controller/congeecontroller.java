package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.example.employee.enteties.congee;
import com.example.employee.enteties.contrat;
import com.example.employee.services.congeeservice;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/congees")
public class congeecontroller {

	@Autowired
	private congeeservice congeeservice;

	public congeecontroller(congeeservice congeeservice) {
		super();
		this.congeeservice = congeeservice;
	}

	@GetMapping("/all")
    public List<congee> Allcongees() {
        List<congee> congs = congeeservice.getallCongees();
        return congs;
    }
	
	@GetMapping("/all/{page}/{size}")
    public Page<congee> Allcontrat(@PathVariable int page , @PathVariable int size) {
    	Page<congee> cnts = congeeservice.getallcongee(page, size);
        return cnts;
    }
	
	@GetMapping("/all/search/{keyword}/{page}/{size}")
	public Page<congee> findByKeyword(@PathVariable String keyword,@PathVariable int page , @PathVariable int size){
		//return produitservice.getallproduits();
		//model.addAttribute("listEmployees",employeeservice.getallEmployees());
		
		
			return congeeservice.findByKeyword(keyword, page, size);
		
		
		
		
	}
	@GetMapping("/all/search//{page}/{size}")
	public Page<congee> getallemployeesbysearchnull(@PathVariable int page , @PathVariable int size){
		//return produitservice.getallproduits();
		//model.addAttribute("listEmployees",employeeservice.getallEmployees());
		
		return congeeservice.getallcongee(page, size);}
		
	
	/*@GetMapping("/departements/new")
	public String creatdepartementform(Model model){
		
		departement dept=new departement();
		model.addAttribute("departements",dept);
		return "create_departement";
		
	}*/
    @PostMapping("/add/{id}/{idemp}")
    public ResponseEntity<Object> adddcong(@RequestBody congee cong,@PathVariable long id,@PathVariable long idemp) {
    return congeeservice.savecongee(cong,id,idemp);
}
  /* @GetMapping("/departements/edit/{id}")
	public String editdepartementform(@PathVariable Long id , Model model){
		
		model.addAttribute("departement",departementservice.getDepartement(id));
		return "edit_departement";
		
	}*/
   
    @PutMapping("/update/{id}/{idtype}/{idemp}")
    public ResponseEntity<Object> updatecongee(@RequestBody congee cong, @PathVariable long id,@PathVariable long idtype,@PathVariable long idemp) {
        return congeeservice.updateCongee(id, cong,idtype,idemp);
    }
	

    @DeleteMapping("/delete/{id}")
    public void deletecongee(@PathVariable long id) {
      congeeservice.deletCongeebyid(id);
  }

  @GetMapping("/get/{id}")
  public congee findcongee(@PathVariable long id) {
      return congeeservice.getCongee(id);
  }


}
