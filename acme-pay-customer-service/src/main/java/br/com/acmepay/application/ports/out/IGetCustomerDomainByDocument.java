package br.com.acmepay.application.ports.out;

import br.com.acmepay.application.domain.model.CustomerDomain;

public interface IGetCustomerDomainByDocument {
    CustomerDomain execute(CustomerDomain customerDomain);
}
