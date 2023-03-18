package api.casino.broker.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import api.casino.broker.message.PromotionMessage;

@Service
//@KafkaListener(topics = "t.commodity.promotion")
public class PromotionListener {
	
	private static final Logger LOG = LoggerFactory.getLogger(PromotionListener.class);
			
	//@KafkaHandler
	public void listenPromotion(@Payload PromotionMessage message) {
		LOG.info("Processing promotion: {}", message);
	}
				
	/*@KafkaHandler
	public void listenJackpot(JackpotMessage message) {
		LOG.info("Processing jackpot: {}", message);
	}*/
}
