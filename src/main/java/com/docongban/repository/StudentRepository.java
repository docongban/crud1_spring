package com.docongban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docongban.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}
