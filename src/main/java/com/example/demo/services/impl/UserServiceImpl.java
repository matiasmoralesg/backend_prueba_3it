package com.example.demo.services.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    @Transactional
    public User saveVote(User user) {
        return iUserRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public boolean existsByEmail(String email) {
        return iUserRepository.existsById(email);
    }
}
