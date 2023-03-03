package com.example.employee.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.employee.enteties.departement;
import com.example.employee.enteties.employee;

import jakarta.transaction.Transactional;
@Transactional
@Repository

public interface deptrepository extends JpaRepository<departement, Long> {
	 @Query(value = "select * from departement  where departement.nom_dept like %:keyword% or departement.status like %:keyword% ", nativeQuery = true)
	 Page<departement> findByKeyword(@Param("keyword") String keyword,Pageable page);
	 @Query(value = "select * from departement  where departement.nom_dept like %:nomDept% ", nativeQuery = true)
	 <department> List<department> findBynomDeptContainingIgnoreCase(@Param("nomDept")String nomDept);
}
