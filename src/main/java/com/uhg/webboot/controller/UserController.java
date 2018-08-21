package com.uhg.webboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhg.webboot.bean.LoginRequest;
import com.uhg.webboot.bean.LoginResponse;
import com.uhg.webboot.bean.User;
import com.uhg.webboot.repository.UserRepository;
import com.uhg.webboot.service.UserService;

//@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("users/login")
	public LoginResponse login(@RequestBody LoginRequest loginRequest) {
		return UserService.login(loginRequest);
	}

	@GetMapping("message")
	public String message() {
		return "Test Message";
	}

	@GetMapping("users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("users/{id}")
	public User getUserById(@PathVariable(value = "id") Integer id) {
		return userRepository.findById(id).get();
	}

	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}

	@PostMapping("users")
	public void insertRecord(@RequestBody User user) {
		userRepository.save(user);
	}

	@PutMapping("users/{id}")
	public void updateUser(@RequestBody User user) {
		// User user = userRepository.findById(id).get();
		userRepository.save(user);
	}
}
