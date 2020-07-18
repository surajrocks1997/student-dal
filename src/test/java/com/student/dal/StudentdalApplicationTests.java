package com.student.dal;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.student.dal.entities.Student;
import com.student.dal.repos.StudentRepository;

@SpringBootTest
class StudentdalApplicationTests {

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void testCreateStudent() {
		Student student = new Student();
		student.setName("John");
		student.setCourse("Java Web");
		student.setFee(30d);
		studentRepository.save(student);
	}

	@Test
	public void testFindStudentById() {
		Optional<Student> studentOptional = studentRepository.findById((long) 1);
		if(studentOptional.isPresent()) {
			Student student = studentOptional.get();
			System.out.println(student);
		}
	}
	
	@Test
	public void testUpdateStudent() {
		Optional<Student> studentOptional = studentRepository.findById((long) 1);
		if(studentOptional.isPresent()) {
			Student student = studentOptional.get();
			student.setFee(20d);
			studentRepository.save(student);
		}
	}
	
	@Test
	public void testDeleteStudent() {
		studentRepository.deleteById(1L);
	}
}
