package br.com.acmepay.adapters.output.kafka.producer;

import br.com.acmepay.application.requests.TransactionRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static br.com.acmepay.config.RabbitConfig.QUEUE_CHECK_DOCUMENT;

@Component
@AllArgsConstructor
@Slf4j
public class MessageProducer {
    private final KafkaTemplate<String, TransactionRequest> kafkaTemplate;

    public String send(String topic, TransactionRequest transactionRequest) {
        log.info("Publishing Kafka: Topic {} / TransactionRequest {}", topic, transactionRequest);
        kafkaTemplate.send(topic, transactionRequest);
        log.info("Published Kafka: Topic {} / TransactionRequest {}", topic, transactionRequest);
        return "send ok";
    }
}
