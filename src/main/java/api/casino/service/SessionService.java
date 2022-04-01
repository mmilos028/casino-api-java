package api.casino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.casino.entity.Session;
import api.casino.repository.SessionRepository;

@Service
public class SessionService {
	
	@Autowired
    private SessionRepository sessionRepository;
	
	public List<Session> findAll() {
		return sessionRepository.findAll();
	}
	
	public Optional<Session> findById(Long id) {
		
		return sessionRepository.findById(id);
	}
	

}
