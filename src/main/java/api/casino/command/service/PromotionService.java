package api.casino.command.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.casino.api.request.PromotionRequest;
import api.casino.command.action.PromotionAction;

@Service
public class PromotionService {
	@Autowired
	private PromotionAction action;
	
	public void createPromotion(PromotionRequest request) {
		action.publishToKafka(request);
	}
}
