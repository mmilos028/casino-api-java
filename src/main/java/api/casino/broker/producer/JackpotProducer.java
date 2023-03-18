package api.casino.broker.producer;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import api.casino.broker.message.JackpotMessage;

@Service
public class JackpotProducer {
	
	private static final Logger LOG = LoggerFactory.getLogger(JackpotProducer.class);
	
	@Autowired
	private KafkaTemplate<String, JackpotMessage> kafkaTemplate;
	
	public void publish(JackpotMessage message) {
		try {
			var sendResult = kafkaTemplate.send("t.commodity.promotion", message).get();
			
			LOG.info("Send result success for message {}", sendResult.getProducerRecord().value());
			
		}catch(InterruptedException | ExecutionException e) {
			LOG.error("Error publishing {}, cause {}", message, e.getMessage());
		}
	}
	
}
