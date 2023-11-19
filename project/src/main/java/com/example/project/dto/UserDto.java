package com.example.project.dto;

import com.example.project.Entity.Role;

public class UserDto {
	
	private String email;
	private String password;
	private Role role;
	private String username;


	private String fullname;

	public UserDto() {}

	public UserDto(String email, String password, Role role, String username,String fullname) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.username = username;
		this.fullname = fullname;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}





}
