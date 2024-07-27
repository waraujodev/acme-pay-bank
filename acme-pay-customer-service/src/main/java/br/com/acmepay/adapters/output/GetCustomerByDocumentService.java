package br.com.acmepay.adapters.output;

import br.com.acmepay.adapters.output.entity.CustommerEntity;
import br.com.acmepay.adapters.output.repository.CustomerRepository;
import br.com.acmepay.application.domain.model.CustomerDomain;
import br.com.acmepay.application.ports.out.IGetCustomerDomainByDocument;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetCustomerByDocumentService implements IGetCustomerDomainByDocument {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerDomain execute(CustomerDomain customerDomain) {
        CustommerEntity custommerEntity = customerRepository.findByDocument(customerDomain.getDocument());
        return CustomerDomain
                .builder()
                .id(custommerEntity.getId())
                .name(custommerEntity.getName())
                .email(custommerEntity.getEmail())
                .phone(custommerEntity.getPhone())
                .document(custommerEntity.getDocument())
                .build();
    }
}
