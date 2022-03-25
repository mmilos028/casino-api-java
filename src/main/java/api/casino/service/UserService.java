package api.casino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.casino.entity.User;
import api.casino.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
