package com.example.employee.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.employee.enteties.congee;
import com.example.employee.enteties.departement;

import jakarta.transaction.Transactional;

//import com.example.employee.enteties.employee;
@Transactional
@Repository
public interface congeerepository extends JpaRepository<congee, Long> {
	 @Query(value = "select * from congee  where congee.date_debut like %:keyword% ", nativeQuery = true)
	 Page<congee> findByKeyword(@Param("keyword") String keyword,Pageable page);

}
