package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.models.AccountDomain;
import br.com.acmepay.application.ports.in.ICreateAccountUseCase;
import br.com.acmepay.application.ports.out.ICheckDocumentCustomer;
import br.com.acmepay.application.ports.out.ICreateAccount;
import br.com.acmepay.application.ports.out.IGetSalaryCustomer;
import br.com.acmepay.application.ports.out.ISendToTransactionTopc;
import br.com.acmepay.application.util.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class CreateAccountUseCase implements ICreateAccountUseCase {

    private final ICreateAccount createAccount;
    private final ICheckDocumentCustomer checkDocumentCustomer;
    private final ISendToTransactionTopc sendToTransactionTopc;
    private final IGetSalaryCustomer getSalaryCustomer;

    @Override
    public void execute(AccountDomain domain) {
        domain.create(createAccount, checkDocumentCustomer, sendToTransactionTopc, getSalaryCustomer);
    }
}
