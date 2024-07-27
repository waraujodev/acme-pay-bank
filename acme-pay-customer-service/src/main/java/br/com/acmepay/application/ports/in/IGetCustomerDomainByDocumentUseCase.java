package br.com.acmepay.application.ports.in;

import br.com.acmepay.application.domain.model.CustomerDomain;

public interface IGetCustomerDomainByDocumentUseCase {
    CustomerDomain execute(CustomerDomain domain);
}
