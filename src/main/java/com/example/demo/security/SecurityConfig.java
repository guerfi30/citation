package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Configuration

@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource

    private UserDetailsService userDetailsService;

    @Override

    protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()

    .antMatchers("/login","/register").permitAll()
    .antMatchers("/admin/**").access("hasRole('ADMIN')")

    .and()

        .formLogin().defaultSuccessUrl("/home/home")

        .loginPage("/login")

        .failureUrl("/login?error=true")

        .and();

          

    }

    @Bean

    public DaoAuthenticationProvider authProvider() {

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);

        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;

    }

    @Override

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(authProvider());

    }

    

    @Bean

    PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

}
