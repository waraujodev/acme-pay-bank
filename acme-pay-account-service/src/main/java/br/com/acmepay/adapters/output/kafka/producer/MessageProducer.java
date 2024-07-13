package br.com.acmepay.adapters.output.kafka.producer;

import br.com.acmepay.application.requests.TransactionRequest;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageProducer {
    private final KafkaTemplate<String, TransactionRequest> kafkaTemplate;

    public String send(String topic, TransactionRequest transactionRequest) {
        kafkaTemplate.send(topic, transactionRequest);
        return "send ok";
    }
}
