package com.example.employee.models;

import com.example.employee.enteties.departement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class empmodel {
	private String nom;
	private String prenom;
	private Long cin;
	private Long deptid;
	

}
