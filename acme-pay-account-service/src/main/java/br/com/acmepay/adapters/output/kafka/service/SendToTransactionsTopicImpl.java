package br.com.acmepay.adapters.output.kafka.service;

import br.com.acmepay.adapters.output.kafka.producer.MessageProducer;
import br.com.acmepay.application.ports.out.ISendToTransactionTopc;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SendToTransactionsTopicImpl implements ISendToTransactionTopc {

    public static final String TOPIC_TRANSACTIONS = "transactions";
    private final MessageProducer messageProducer;

    @Override
    public void execute(String message) {
        messageProducer.send(TOPIC_TRANSACTIONS, message);
    }
}
