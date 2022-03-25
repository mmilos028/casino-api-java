package api.casino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import api.casino.entity.User;
import api.casino.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	UserService userService;

	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers(){
		
		return userService.findAll();
		
	}
}
