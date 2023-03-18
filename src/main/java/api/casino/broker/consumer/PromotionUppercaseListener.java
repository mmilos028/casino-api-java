package api.casino.broker.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import api.casino.broker.message.JackpotMessage;
import api.casino.broker.message.PromotionMessage;

@Service
@KafkaListener(topics="t.commodity.promotion-uppercase")
public class PromotionUppercaseListener {
	
	private static final Logger LOG = LoggerFactory.getLogger(PromotionUppercaseListener.class);
	
	@KafkaHandler
	public void listenPromotion(PromotionMessage message) {
		LOG.info("Processing uppercase promotion: {}", message);
	}
}
