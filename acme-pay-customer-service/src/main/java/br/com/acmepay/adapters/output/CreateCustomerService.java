package br.com.acmepay.adapters.output;

import br.com.acmepay.adapters.output.entity.CustommerEntity;
import br.com.acmepay.adapters.output.repository.CustomerRepository;
import br.com.acmepay.application.domain.model.CustomerDomain;
import br.com.acmepay.application.ports.out.ICreateCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreateCustomerService implements ICreateCustomer {

    private final CustomerRepository customerRepository;

    @Override
    public void execute(CustomerDomain customerDomain) {
        CustommerEntity custommerEntity = CustommerEntity.builder()
                .name(customerDomain.getName())
                .email(customerDomain.getEmail())
                .phone(customerDomain.getPhone())
                .document(customerDomain.getDocument())
                .created_at(customerDomain.getCreated_at())
                .updated_at(customerDomain.getUpdated_at())
                .build();
        customerRepository.save(custommerEntity);
    }
}
