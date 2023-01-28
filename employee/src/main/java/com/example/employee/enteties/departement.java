package com.example.employee.enteties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
//le produit est une classe que est va stockee dans db
@Entity
public class departement {
	//id est cle primaire
	@Id
	//id est generer automatique par spring : auto increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDept;
	private String nomDept;
	@OneToMany(mappedBy = "departement")
	Collection <employee> employees =new ArrayList <> ();
	

	
	
	
	

}
