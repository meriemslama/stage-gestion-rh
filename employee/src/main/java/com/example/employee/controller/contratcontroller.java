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

import com.example.employee.enteties.contrat;
import com.example.employee.services.contratservice;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/contrats")
public class contratcontroller {

	@Autowired
	private contratservice contratservice;

	public contratcontroller(contratservice contratservice) {
		super();
		this.contratservice = contratservice;
	}

	@GetMapping("/all")
    public List<contrat> Allcontrats() {
        List<contrat> conts = contratservice.getallContrats();
        return conts;
    }
	/*@GetMapping("/departements/new")
	public String creatdepartementform(Model model){
		
		departement dept=new departement();
		model.addAttribute("departements",dept);
		return "create_departement";
		
	}*/
    @PostMapping("/add")
    public ResponseEntity<Object> addcontrat(@RequestBody contrat cont) {
    return contratservice.saveContrat(cont);
}
  /* @GetMapping("/departements/edit/{id}")
	public String editdepartementform(@PathVariable Long id , Model model){
		
		model.addAttribute("departement",departementservice.getDepartement(id));
		return "edit_departement";
		
	}*/
   
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updatedept(@RequestBody contrat cont, @PathVariable long id) {
        return contratservice.updateContrat(id, cont);
    }
	

    @DeleteMapping("/delete/{id}")
    public void deletecontrat(@PathVariable long id) {
      contratservice.deletContratbyid(id);
  }

  @GetMapping("/get/{id}")
  public contrat findcontrat(@PathVariable long id) {
      return contratservice.getContrat(id);
  }


}
