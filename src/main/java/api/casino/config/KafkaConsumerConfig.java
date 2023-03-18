package api.casino.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
public class KafkaConsumerConfig {
	
	@Autowired
	private KafkaProperties kafkaProperties;
	
	@Bean
	public ConsumerFactory<Object, Object> consumerFactory(){
		var props = kafkaProperties.buildConsumerProperties();
		
		//props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		//props.put(ConsumerConfig.GROUP_ID_CONFIG, "kafka-group-id");
		//props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		//props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		
		props.put(ConsumerConfig.METADATA_MAX_AGE_CONFIG, "120000");
				
		return new DefaultKafkaConsumerFactory<Object, Object>(props);
	}
}
