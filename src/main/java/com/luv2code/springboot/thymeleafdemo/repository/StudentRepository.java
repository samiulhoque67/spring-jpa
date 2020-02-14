package com.luv2code.springboot.thymeleafdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {



}
