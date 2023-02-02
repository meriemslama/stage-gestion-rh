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

import com.example.employee.enteties.congee;
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
	/*@GetMapping("/departements/new")
	public String creatdepartementform(Model model){
		
		departement dept=new departement();
		model.addAttribute("departements",dept);
		return "create_departement";
		
	}*/
    @PostMapping("/add")
    public ResponseEntity<Object> adddcong(@RequestBody congee cong) {
    return congeeservice.savecongee(cong);
}
  /* @GetMapping("/departements/edit/{id}")
	public String editdepartementform(@PathVariable Long id , Model model){
		
		model.addAttribute("departement",departementservice.getDepartement(id));
		return "edit_departement";
		
	}*/
   
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updatecongee(@RequestBody congee cong, @PathVariable long id) {
        return congeeservice.updateCongee(id, cong);
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
