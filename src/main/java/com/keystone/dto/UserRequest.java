package com.keystone.dto;

import com.keystone.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {
	
	@NotBlank(message = "Full name is required")
	private String fullName;
	
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email")
	private String email;
	
	@NotBlank(message = "Password is required")
	private String password;
	
	private String phone;
	
	private Role role;
	
	public UserRequest() {
		super();
	}
	
	public UserRequest(String fullName, String email, String password, String phone, Role role) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
	}



	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

}
