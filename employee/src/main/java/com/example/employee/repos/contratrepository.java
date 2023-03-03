package com.example.employee.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.employee.enteties.contrat;
//import com.example.employee.enteties.employee;
import com.example.employee.enteties.departement;

@Repository
public interface contratrepository extends JpaRepository<contrat, Long>{
	 @Query(value = "select * from contrat  where contrat.date_debut like %:keyword% ", nativeQuery = true)
	 Page<contrat> findByKeyword(@Param("keyword") String keyword,Pageable page);

}
