package com.keystone.service;

import com.keystone.dto.LoginRequest;
import com.keystone.dto.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);

}