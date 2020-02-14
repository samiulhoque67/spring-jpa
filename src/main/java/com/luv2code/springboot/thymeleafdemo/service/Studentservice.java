package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Student;

public interface Studentservice {


List<Student> getStudents();

Student get(int theId);

void saveStudent(Student student);

void delete(int theId);

Student sendmail(int theId);
}
