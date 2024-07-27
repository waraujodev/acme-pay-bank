package br.com.acmepay.adapters.output.feing;

import br.com.acmepay.adapters.output.feing.response.CustomerSalaryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "customerClient", url = "localhost:8082/api/v1/customers")
public interface CustomerClient {

    @GetMapping("/salary/{document}")
    CustomerSalaryResponse getSalary(@PathVariable("document") String document);
}
