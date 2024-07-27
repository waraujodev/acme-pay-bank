package br.com.acmepay.adapters.input;

import br.com.acmepay.adapters.input.api.request.CustomerRequest;
import br.com.acmepay.adapters.input.api.response.CustomerResponse;
import br.com.acmepay.adapters.input.api.response.CustomerSalaryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/customers")
public interface ICustomerResourceAPI {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CustomerResponse create(@RequestBody CustomerRequest request);

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    @RequestMapping("/salary/{document}")
    CustomerSalaryResponse getSalary(@PathVariable("document") String document);
}
