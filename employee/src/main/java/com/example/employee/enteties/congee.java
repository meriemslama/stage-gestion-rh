package com.example.employee.enteties;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class congee {
	  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  
   private long Id;
   private String dateDebut;
   private String dateFin;
	@OneToMany(mappedBy = "congee")
	Collection <employee> employees =new ArrayList <> ();
	@ManyToOne
	@JsonIgnore
	typecongee typecongee;

   










   
}
