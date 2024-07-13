package br.com.acmepay.adapters.output.kafka.service;

import br.com.acmepay.adapters.output.kafka.producer.MessageProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SendToTransactionsTopicImpl implements SendToTransactionsTopic {

    public static final String TOPIC_TRANSACTIONS = "transactions";
    private final MessageProducer messageProducer;

    @Override
    public void send(String message) {
        messageProducer.send(TOPIC_TRANSACTIONS, message);
    }
}
