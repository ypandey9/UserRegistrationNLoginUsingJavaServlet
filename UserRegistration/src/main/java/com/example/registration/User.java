// src/com/example/registration/User.java
package com.example.registration;

public class User {
    private String fullName;
    private String userName;
    private String password;
    private String email;

    public User(String fullName, String userName, String password, String email) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public User() {
		// TODO Auto-generated constructor stub
	}

	public String getFullName() {
        return fullName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
