package org.stack.oasis.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.springframework.data.annotation.Id;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
*
* @author Prakash Nagaraj
* @version 1.0 
*/
public class User {



    @NotNull
    @JsonDeserialize
    private String password;

    @NotNull
    private String userName;
    private String[] roles;
    @NotNull
    private String fullName;
    
    @NotNull
    @Size(min = 1)
    private String firstName;
    @NotNull
    @Size(min = 1)
    private String lastName;
    private String status="deactivated";
    private String location;
    private String email;
    private String otp="";
    private int numberOfAttempts=0;


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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public int getNumberOfAttempts() {
		return numberOfAttempts;
	}

	public void setNumberOfAttempts(int numberOfAttempts) {
		this.numberOfAttempts = numberOfAttempts;
	}
    //removed roles as it might be a future feature but not required now
	// private String roles[];



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    
     public String[] getRoles() {
         return roles;
     }

     public void setRoles(String[] roles) {
         this.roles = roles;
     }
}
