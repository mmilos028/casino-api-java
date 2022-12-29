package api.casino.command.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.casino.command.action.UserAction;
import api.casino.entity.User;

@Service
public class UserServiceImpl {
	
	@Autowired
	private UserAction action;
	
	public Long saveUser(User user) {
		
		Long userId = action.saveToDatabase(user);
		
		return userId;
	}
}
