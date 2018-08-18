package com.example.demo.dao;

import com.example.demo.domain.User;
import com.example.demo.jpaRepository.MyRepository;

public interface UserDao extends MyRepository<User,Integer> {
    User findByUsername(String username);
}
