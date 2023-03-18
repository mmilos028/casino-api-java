package api.casino.broker.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.support.serializer.JsonSerde;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.casino.broker.message.PromotionMessage;

@Configuration
@EnableKafkaStreams
public class PromotionUppercaseJsonStream {

	private static Logger LOG = LoggerFactory.getLogger(PromotionUppercaseJsonStream.class);
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Bean
	public KStream<String, PromotionMessage> kstreamPromotionUppercase(StreamsBuilder builder) {
		var stringSerde = Serdes.String();
		
		var jsonSerde = new JsonSerde<>(PromotionMessage.class);
		
		KStream<String, PromotionMessage> sourceStream = builder.stream("t.commodity.promotion",
				Consumed.with(stringSerde, jsonSerde));
		
		
		KStream<String, PromotionMessage> uppercaseStream = sourceStream.mapValues(this::uppercasePromotionCode);
		
		uppercaseStream.to("t.commodity.promotion-uppercase", Produced.with(stringSerde, jsonSerde));
		
		sourceStream.print(Printed.<String, PromotionMessage>toSysOut().withLabel("JSON Serde Original Stream"));
		uppercaseStream.print(Printed.<String, PromotionMessage>toSysOut().withLabel("JSON Serde Uppercase Stream"));
		
		return sourceStream;
	}
	
	private PromotionMessage uppercasePromotionCode(PromotionMessage message) {
		return new PromotionMessage(message.getPromotionCode().toUpperCase());
	}
}
