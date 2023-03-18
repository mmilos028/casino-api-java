package api.casino.command.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.casino.api.request.JackpotRequest;
import api.casino.broker.message.JackpotMessage;
import api.casino.broker.producer.JackpotProducer;

@Component
public class JackpotAction {

	@Autowired
	private JackpotProducer producer;
		
	public void publishToKafka(JackpotRequest request) {
		var message = new JackpotMessage(request.getJackpotCode());
		
		producer.publish(message);
	}
}
