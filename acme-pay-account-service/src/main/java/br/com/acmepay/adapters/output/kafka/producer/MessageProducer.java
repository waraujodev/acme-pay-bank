package br.com.acmepay.adapters.output.kafka.producer;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public String send(String topic, String message) {
        kafkaTemplate.send(topic, message);
        return topic + " - " + message;
    }
}
