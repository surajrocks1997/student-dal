package com.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
