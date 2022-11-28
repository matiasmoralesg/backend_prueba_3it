package com.example.demo.services;

import com.example.demo.entity.User;

import java.util.List;

public interface IUserService {

    User saveVote(User user);

    List<User> findAll();

    boolean existsByEmail(String email);
}
