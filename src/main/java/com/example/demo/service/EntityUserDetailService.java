package com.example.demo.service;



import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;

import com.example.demo.model.UserEntity;

import com.example.demo.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service

public class EntityUserDetailService implements UserDetailsService {

@Autowired

UserRepository userRepository;

@Override

public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

final UserEntity customer = userRepository.findByEmail(email);

if (customer == null) {

throw new UsernameNotFoundException(email);

}

UserDetails user = User.withUsername(customer.getEmail())

.password(customer.getPassword())

.roles(customer.getRoles().isEmpty() ? "USER" : customer.getRoles()).build();

return user;

}

}


