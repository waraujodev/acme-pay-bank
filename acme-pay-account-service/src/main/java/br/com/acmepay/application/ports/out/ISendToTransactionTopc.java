package br.com.acmepay.application.ports.out;

import br.com.acmepay.adapters.input.api.request.DocumentRequest;

public interface ISendToTransactionTopc {
    void execute(String request);
}
