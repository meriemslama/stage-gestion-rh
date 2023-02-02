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

import com.example.employee.enteties.typecongee;
import com.example.employee.services.typecongeeservice;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/type/congees")
public class typecongeecontroller {

	@Autowired
	private typecongeeservice typecongeeservice;

	public typecongeecontroller(typecongeeservice typecongeeservice) {
		super();
		this.typecongeeservice = typecongeeservice;
	}

	@GetMapping("/all")
    public List<typecongee> Alltypecongee() {
        List<typecongee> tcongs = typecongeeservice.getalltypescongees();
        return tcongs;
    }
	/*@GetMapping("/departements/new")
	public String creatdepartementform(Model model){
		
		departement dept=new departement();
		model.addAttribute("departements",dept);
		return "create_departement";
		
	}*/
    @PostMapping("/add")
    public ResponseEntity<Object> addtypecongee(@RequestBody typecongee tcong) {
    return typecongeeservice.saveTypeCongee(tcong);
}
  /* @GetMapping("/departements/edit/{id}")
	public String editdepartementform(@PathVariable Long id , Model model){
		
		model.addAttribute("departement",departementservice.getDepartement(id));
		return "edit_departement";
		
	}*/
   
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updatetypecongee(@RequestBody typecongee tcong, @PathVariable long id) {
        return typecongeeservice.updateTypeCongee(id, tcong);
    }
	

    @DeleteMapping("/delete/{id}")
    public void deletetypecongee(@PathVariable long id) {
      typecongeeservice.delettypeCongeebyid(id);
  }

  @GetMapping("/get/{id}")
  public typecongee findtypecongee(@PathVariable long id) {
      return typecongeeservice.gettypeCongee(id);
  }


}
