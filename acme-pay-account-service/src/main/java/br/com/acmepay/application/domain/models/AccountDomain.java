package br.com.acmepay.application.domain.models;

import br.com.acmepay.adapters.input.api.request.DocumentRequest;
import br.com.acmepay.application.domain.exception.BalanceToWithdrawException;
import br.com.acmepay.application.ports.out.ICheckDocumentCustomer;
import br.com.acmepay.application.ports.out.ICreateAccount;
import br.com.acmepay.application.ports.out.ISendToTransactionTopc;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDomain {

    private Long id;
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private Boolean close;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String customerDocument;

    public void create(ICreateAccount createAccount, ICheckDocumentCustomer checkDocumentCustomer, ISendToTransactionTopc sendToTransactionTopc) {
        var doc = DocumentRequest.builder().document(this.customerDocument).build();
        checkDocumentCustomer.execute(doc);
        createAccount.execute(this);
        sendToTransactionTopc.execute(doc.getDocument());
    }

    public void deposit(BigDecimal amount){
        this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws BalanceToWithdrawException {
        if (this.balance.compareTo(amount) >= 0){
            this.balance.subtract(amount);
        }else {
            throw new BalanceToWithdrawException("error withdraw");
        }
    }
}
