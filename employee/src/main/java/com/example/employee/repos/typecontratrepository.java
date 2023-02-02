package com.example.employee.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.example.employee.enteties.employee;
import com.example.employee.enteties.typecontrat;

@Repository
public interface typecontratrepository extends JpaRepository<typecontrat, Long>{

}
