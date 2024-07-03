package br.com.acmepay.adapters.output.queue;

import br.com.acmepay.adapters.input.api.request.DocumentRequest;

public interface ProducerMessage {
    void publish(String routingKey, DocumentRequest documentRequest);
}
