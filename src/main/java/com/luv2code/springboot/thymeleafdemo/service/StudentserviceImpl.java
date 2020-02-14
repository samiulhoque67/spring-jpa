package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.entity.Student;
import com.luv2code.springboot.thymeleafdemo.repository.StudentRepository;
@Service
public class StudentserviceImpl implements Studentservice {
	@Autowired
    private JavaMailSender javaMailSender;
	@Autowired
	private StudentRepository studentrepository;
	
	
	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentrepository.findAll();
	}

	@Override
	public Student get(int theId) {
Optional<Student> result = studentrepository.findById(theId);
		
		Student student = null;
		
		if (result.isPresent()) {
			student = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find student id - " + theId);
		}
return student;
	}

	@Override
	public void saveStudent(Student student) {
		studentrepository.save(student);
		
	}

	@Override
	public void delete(int theId) {
		studentrepository.deleteById(theId);
		
	}

	@Override
	public Student sendmail(int theId) {
Optional<Student> result = studentrepository.findById(theId);
		
		Student student = null;
		
		if (result.isPresent()) {
			student = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find student id - " + theId);
		}
		String email=student.getEmail();
		String username=student.getL_name();
		
		SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject("Test Message");
        msg.setText("Hello "+username+".\nTake love");

        javaMailSender.send(msg);
		//Query theQuery = entityManager.createQuery("select email from Student where Student.id=:theId");
		return student;
	}
		
	}
	

