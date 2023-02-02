package com.example.employee.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.enteties.congee;

import jakarta.transaction.Transactional;

//import com.example.employee.enteties.employee;
@Transactional
@Repository
public interface congeerepository extends JpaRepository<congee, Long> {

}
