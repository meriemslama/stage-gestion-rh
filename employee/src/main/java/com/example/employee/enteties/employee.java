package com.example.employee.enteties;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class employee {
	  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  
   private long Id;
   private String nom;
   private String prenom;
   private long cin;
   private String poste;
   //private int numdept;
   @ManyToOne
   @JsonIgnore
   departement departement;
   @ManyToOne
   @JsonIgnore
   congee congee;
   @ManyToOne
   @JsonIgnore
   contrat contrat;






   
}
