package br.com.acmepay.application.domain.model;

import br.com.acmepay.application.ports.out.ICreateCustomer;
import br.com.acmepay.application.ports.out.IGetCustomerDomainByDocument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDomain {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    private BigDecimal salary;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public void create(ICreateCustomer iCreateCustomer) {
        iCreateCustomer.execute(this);
    }

    public CustomerDomain getCustomerDomainByDocument(IGetCustomerDomainByDocument getCustomerDomainByDocument) {
        return getCustomerDomainByDocument.execute(this);
    }
}
