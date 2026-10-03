package com.example.stud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stud.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

}