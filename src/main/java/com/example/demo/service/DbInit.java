package com.example.demo.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import com.example.demo.model.UserEntity;

import com.example.demo.repository.UserRepository;

@Service

public class DbInit implements CommandLineRunner {

@Autowired

UserRepository userRepository ;

@Autowired

private PasswordEncoder passwordEncoder ;



@Override

public void run(String... args) throws Exception {

// TODO Auto-generated method stub



userRepository.deleteAll();



UserEntity user = new UserEntity();

user.setEmail("sguerfi12@yahoo.com");

user.setFirstName("TOTO");

user.setLastName("TOTO");

user.setAccountVerified(true);

user.setPassword(passwordEncoder.encode("1234"));
user.setRoles("USER");

UserEntity user1 = new UserEntity();

user1.setEmail("sguerfi12@gmail.com");

user1.setFirstName("TITI");

user1.setLastName("TITI");

user1.setAccountVerified(true);

user1.setPassword(passwordEncoder.encode("12345"));
user1.setRoles("ADMIN");



List<UserEntity> liste = new ArrayList<>();

liste.add(user);

userRepository.saveAndFlush(user);

liste.add(user1);

userRepository.saveAndFlush(user1);









}

}
