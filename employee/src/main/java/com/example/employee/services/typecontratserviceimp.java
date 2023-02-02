package com.example.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ResponseStatusException;

import com.example.employee.enteties.typecontrat;
import com.example.employee.repos.typecontratrepository;

import jakarta.transaction.Transactional;


@Service
public class typecontratserviceimp implements typecontratservice{

	@Autowired
   typecontratrepository typecontratrepository;
	@Override
	@CrossOrigin
	@Transactional
	public ResponseEntity<Object> saveTypeContrat(typecontrat tc) {
		// TODO Auto-generated method stub
		typecontratrepository
        .findById(tc.getId())
        .ifPresentOrElse(
                tcong -> {
                    throw new ResponseStatusException(HttpStatus.FOUND, "type de contrat ID alredy exist");
                }, () -> {
                	typecontratrepository.save(tc);
                }
        );
		  return ResponseEntity.ok(tc);
	}
	@Override
	public typecontrat gettypeContrat(Long id) {
		// TODO Auto-generated method stub
		return  typecontratrepository.findById(id).get();
	}

	@Override
	@Transactional
	public ResponseEntity<Object> updateTypeContrat(long id, typecontrat tc) {
		// TODO Auto-generated method stub
		 typecontratrepository
         .findById(id)
         .ifPresentOrElse(tcont -> {
        	 tcont.setType(tc.getType());
        	 tcont.setContrat(tc.getContrat());
     
        	
        	 typecontratrepository.save(tcont);
         }, () -> {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "type contrat to update not found");
         });
		 // return ResponseEntity.accepted().body("Successfully updated acte");
		 return ResponseEntity.ok(tc);	}

	@Override
	@Transactional
	


	public void delettypeContratbyid(Long id) {
		// TODO Auto-generated method stub
		 typecontratrepository
         .findById(id)
         .ifPresentOrElse(tcont -> {
        	 typecontratrepository.delete(tcont);
         }, () -> {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "type of contrat to delete not found");
         });	

		
	}

	

	@Override
	public List<typecontrat> getalltypescontrat() {
		//List<departement>departements=new ArrayList<>();
		return typecontratrepository.findAll();
		// return departements;
	}
	

}
