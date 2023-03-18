package api.casino.command.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.casino.api.request.JackpotRequest;
import api.casino.command.action.JackpotAction;

@Service
public class JackpotService {
	@Autowired
	private JackpotAction action;
	
	public void createJackpot(JackpotRequest request) {
		action.publishToKafka(request);
	}
}