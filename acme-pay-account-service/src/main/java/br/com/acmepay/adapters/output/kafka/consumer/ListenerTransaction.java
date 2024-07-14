package br.com.acmepay.adapters.output.kafka.consumer;

import br.com.acmepay.application.requests.TransactionRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListenerTransaction {

    @KafkaListener(topics = "transactions", groupId = "group")
    public void teste(TransactionRequest transactionRequest) {
        try {
            log.info("Recebendo TransactionRequest: {}.", transactionRequest);
        } catch (Exception e) {
            log.error("deu erro");
        }
    }
}
