package api.casino.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaCreateTopics {

	@Bean
	public NewTopic promotionTopic() {
		return TopicBuilder.name("t.commodity.promotion")
		//.partitions(1)
		//.replicas(1)
		.build()
		;
	}
	
	@Bean
	public NewTopic promotionUppercaseTopic() {
		return TopicBuilder.name("t.commodity.promotion-uppercase")
		//.partitions(1)
		//.replicas(1)
		.build()
		;
	}
}
