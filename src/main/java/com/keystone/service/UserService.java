package com.keystone.service;

import java.util.List;

import com.keystone.dto.UserRequest;
import com.keystone.dto.UserResponse;

public interface UserService {
	
	UserResponse createUser(UserRequest request);
	
	List<UserResponse> getAllUsers();
	
	UserResponse getUserById(Long id);
	
	void deleteUser(Long id);

}
