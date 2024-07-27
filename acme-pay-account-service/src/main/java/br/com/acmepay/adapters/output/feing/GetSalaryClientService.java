package br.com.acmepay.adapters.output.feing;

import br.com.acmepay.adapters.output.feing.response.CustomerSalaryResponse;
import br.com.acmepay.application.ports.out.IGetSalaryCustomer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
@Slf4j
public class GetSalaryClientService implements IGetSalaryCustomer {

    private final CustomerClient customerClient;
    @Override
    public BigDecimal execute(String document) {
        CustomerSalaryResponse customerSalaryResponse = customerClient.getSalary(document);
        return customerSalaryResponse.getSalary();
    }
}
