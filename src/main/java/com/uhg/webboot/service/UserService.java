package com.uhg.webboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhg.webboot.bean.LoginRequest;
import com.uhg.webboot.bean.LoginResponse;
import com.uhg.webboot.repository.UserRepository;
@Service
public class UserService {
	
	@Autowired
    private UserRepository repository;
	@Autowired
    private static CaptchaService captchaService;
	
	public static LoginResponse login(LoginRequest loginRequest) {
		LoginResponse loginResponse = new LoginResponse();
		System.out.println("Captcha Response String :"+loginRequest.getRecaptchaResponse());
		boolean captchaVerified = captchaService.verify(loginRequest.getRecaptchaResponse());
		if (!captchaVerified) {
			loginResponse.setMessage("Invalid captcha");
			loginResponse.setStatus(400);
		}
		if (captchaVerified && loginRequest.getEmail().equals("test@gmail.com")
				&& loginRequest.getPassword().equals("password")) {
			loginResponse.setMessage("Success");
			loginResponse.setStatus(200);
			loginResponse.setUsername("test");
			loginResponse.setToken("token");
		} else {
			loginResponse.setMessage("Invalid credentials.");
			loginResponse.setStatus(400);
		}
		return loginResponse;
	}

}
