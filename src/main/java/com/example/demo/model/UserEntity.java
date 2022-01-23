package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class UserEntity {
	    
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)

	 private Long id;

	 private String firstName;

	 private String lastName;

	 @Column(unique = true)

	 private String email;

	 private String password;
     private boolean accountVerified;

     private String roles;

	    public Long getId() {

	        return id;

	    }

	    public String getFirstName() {

	        return firstName;

	    }

	    public void setFirstName(String firstName) {

	        this.firstName = firstName;

	    }

	    public String getLastName() {

	        return lastName;

	    }

	    public void setLastName(String lastName) {

	        this.lastName = lastName;

	    }

	    public String getEmail() {

	        return email;

	    }

	    public void setEmail(String email) {

	        this.email = email;

	    }

	    public String getPassword() {

	        return password;

	    }

	    public void setPassword(String password) {

	        this.password = password;

	    }

	   

	    public boolean isAccountVerified() {

	        return accountVerified;

	    }

	    public void setAccountVerified(boolean accountVerified) {

	        this.accountVerified = accountVerified;

	    }

	   @Override

	    public boolean equals(Object o) {

	        if (this == o) return true;

	        if (o == null || getClass() != o.getClass()) return false;

	        UserEntity that = (UserEntity) o;

	        return Objects.equals(email, that.email);

	    }

	    @Override

	    public int hashCode() {

	        return Objects.hash(email);

	    }
	    
	    public String getRoles() {

	        return this.roles;

	    }

	    public void setRoles(String roles) {

	        this.roles = roles;

	    }

}


