package br.com.acmepay.application.ports.out;

import br.com.acmepay.application.domain.models.AccountDomain;

import java.math.BigDecimal;

public interface IGetSalaryCustomer {

    BigDecimal execute(String document);
}
