package br.com.acmepay.application.ports.out;

import br.com.acmepay.application.requests.TransactionRequest;

public interface ISendToTransactionTopc {
    void execute(TransactionRequest request);
}
