package com.example.demo.dao;

import com.example.demo.domain.Student;
import com.example.demo.jpaRepository.MyRepository;

public interface StudentDao extends MyRepository<Student,Integer> {
}
