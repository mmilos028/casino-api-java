package api.casino.command.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.casino.api.request.PromotionRequest;
import api.casino.broker.message.PromotionMessage;
import api.casino.broker.producer.PromotionProducer;

@Component
public class PromotionAction {

	@Autowired
	private PromotionProducer producer;
		
	public void publishToKafka(PromotionRequest request) {
		var message = new PromotionMessage(request.getPromotionCode());
		
		producer.publish(message);
	}
}
