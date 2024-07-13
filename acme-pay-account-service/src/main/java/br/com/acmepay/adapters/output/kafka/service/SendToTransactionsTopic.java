package br.com.acmepay.adapters.output.kafka.service;

public interface SendToTransactionsTopic {
    void send(String message);
}
