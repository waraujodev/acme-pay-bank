package br.com.acmepay.adapters.input.controller;

import br.com.acmepay.adapters.input.ICustomerResourceAPI;
import br.com.acmepay.adapters.input.api.request.CustomerRequest;
import br.com.acmepay.adapters.input.api.response.CustomerResponse;
import br.com.acmepay.application.domain.model.CustomerDomain;
import br.com.acmepay.application.ports.in.ICreateCustomerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class CustomerController implements ICustomerResourceAPI {

    private final ICreateCustomerUseCase createCustomerUseCase;

    @Override
    public CustomerResponse create(CustomerRequest request) {
        var domain = CustomerDomain.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .document(request.getDocument())
                .created_at(LocalDateTime.now())
                .updated_at(null)
                .build();
        createCustomerUseCase.execute(domain);
        return CustomerResponse.builder()
                .message("customer created!")
                .build();
    }
}
