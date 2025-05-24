package com.cg.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.entities.Student;


public interface StudentRepository extends CrudRepository<Student, Integer>{

}
