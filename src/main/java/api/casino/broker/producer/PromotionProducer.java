package api.casino.broker.producer;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import api.casino.broker.message.PromotionMessage;

@Service
public class PromotionProducer {

	private static final Logger LOG = LoggerFactory.getLogger(PromotionProducer.class);

	@Autowired
	private KafkaTemplate<String, PromotionMessage> kafkaTemplate;
	
	public void publish(PromotionMessage promotionMessage) {
		Message<PromotionMessage> message = MessageBuilder.withPayload(promotionMessage)
				.setHeader(KafkaHeaders.TOPIC, "t.commodity.promotion").build();

		// var sendResult = kafkaTemplate.send("t.commodity.promotion", message).get();
		kafkaTemplate.send(message);
		
		LOG.info("Send result success for message {}", promotionMessage);
	}

}
