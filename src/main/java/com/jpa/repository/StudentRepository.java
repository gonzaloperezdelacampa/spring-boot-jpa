package com.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.jpa.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
