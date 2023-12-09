package com.nagarro.training.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.dao.UserRepo;
import com.nagarro.training.model.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {
	@Autowired
	UserRepo repo;
	
//	@PostMapping("/register")
//	public User registerUser(@RequestBody User user) {
//		repo.save(user);
//		return user;
//	}
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
	    Optional<User> existingUser = repo.findByusername(user.getUsername());
	    
	    if (existingUser.isPresent()) {
	        return ResponseEntity.badRequest().build();
	    }
	    
	    User savedUser = repo.save(user);
	    return ResponseEntity.ok(savedUser);
	}

	
	@PostMapping("/login")
	@ResponseBody
	public Boolean loginUser(@RequestParam("username") String username, @RequestParam("pass")String password, HttpSession session) {
		Optional<User> user = repo.findByusername(username);
		
		if(user.isPresent()&& user.get().getPass().equals(password)) {
			System.out.println(user.get());
			session.setAttribute(username, username);
			System.out.println("User login successfully" + session);
			return true;
		}else {
			System.out.println("User login failed");
			return false;
		}
	}
	
	@GetMapping("/logout")
	public void handleLogout(HttpServletRequest request) {
		System.out.println("in api call");
	    HttpSession session = request.getSession(false);
	    System.out.println(request.getSession(false));
	    if (session != null) {
	    	System.out.println("Invalidated");
	        session.invalidate();
	    }
	    System.out.println(request.getSession(false));
	    return;
	    
	}
	
	
	
	

}
