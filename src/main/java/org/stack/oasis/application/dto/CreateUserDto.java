package org.stack.oasis.application.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
*
* @author Prakash Nagaraj
* @version 1.0 
*/
public class CreateUserDto {

    @NotNull
    @Size(min = 1)
    private String firstName;
    @NotNull
    @Size(min = 1)
    private String lastName;
    
    private String location;
    
    private String email;
    

    private String fullName;

    @NotNull
    @Size(min = 1)
    private String userName;

    @NotNull
    @Size(min = 1)
    private String password;
    
    private String[] roles;
    
   
    public String getFirstName() {
		return firstName;
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

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	public String getFullName() {
        return firstName+""+lastName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

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

}
