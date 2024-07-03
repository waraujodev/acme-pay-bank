package br.com.acmepay.adapters.input;

import br.com.acmepay.adapters.input.api.request.CustomerRequest;
import br.com.acmepay.adapters.input.api.response.CustomerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/api/v1/customers")
public interface ICustomerResourceAPI {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CustomerResponse create(@RequestBody CustomerRequest request);
}
