package com.example.employee.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.enteties.typecontrat;
import com.example.employee.enteties.user;

@Repository
public interface userrepository extends JpaRepository<user, Long>{

}