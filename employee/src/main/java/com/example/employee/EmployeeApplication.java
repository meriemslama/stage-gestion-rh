package com.example.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.employee.repos.emprepository;

@SpringBootApplication
public class EmployeeApplication implements CommandLineRunner{
	  @Autowired
	private emprepository emprepository;
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*employee produit1=new employee("n","er",12,1);
		emprepository.save(produit1);
		employee produit2=new employee("h","fg",1,12);
		emprepository.save(produit2);*/
	}

}
