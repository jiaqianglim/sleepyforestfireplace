package com.togetherness.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.togetherness.security.repository.UserRepository;

@Service
public class UserService {
    @Autowired UserRepository userRepository;
}
