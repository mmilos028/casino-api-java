package api.casino.command.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.casino.entity.User;
import api.casino.repository.UserDaoImpl;

@Component
public class UserAction {
	
	@Autowired
	UserDaoImpl userDaoImpl;

	public Long saveToDatabase(User u) {
		
		return userDaoImpl.addUser(u);
		
	}
}
