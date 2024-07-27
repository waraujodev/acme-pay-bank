package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.model.CustomerDomain;
import br.com.acmepay.application.ports.in.IGetCustomerDomainByDocumentUseCase;
import br.com.acmepay.application.ports.out.IGetCustomerDomainByDocument;
import br.com.acmepay.application.util.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class GetCustomerDomainByDocumentUseCase implements IGetCustomerDomainByDocumentUseCase {

    private IGetCustomerDomainByDocument getCustomerDomainByDocument;

    @Override
    public CustomerDomain execute(CustomerDomain domain) {
        return domain.getCustomerDomainByDocument(getCustomerDomainByDocument);
    }
}
