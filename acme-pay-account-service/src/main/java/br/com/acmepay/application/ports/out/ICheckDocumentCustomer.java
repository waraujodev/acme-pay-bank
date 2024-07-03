package br.com.acmepay.application.ports.out;

import br.com.acmepay.adapters.input.api.request.DocumentRequest;

public interface ICheckDocumentCustomer {
    void execute(DocumentRequest request);
}
