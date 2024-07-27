package br.com.acmepay.application.domain.models;

import br.com.acmepay.adapters.input.api.request.DocumentRequest;
import br.com.acmepay.application.domain.exception.BalanceToWithdrawException;
import br.com.acmepay.application.ports.out.ICheckDocumentCustomer;
import br.com.acmepay.application.ports.out.ICreateAccount;
import br.com.acmepay.application.ports.out.IGetSalaryCustomer;
import br.com.acmepay.application.ports.out.ISendToTransactionTopc;
import br.com.acmepay.application.requests.TransactionRequest;
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
    private BigDecimal limit;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String customerDocument;

    public void create(ICreateAccount createAccount, ICheckDocumentCustomer checkDocumentCustomer, ISendToTransactionTopc sendToTransactionTopc, IGetSalaryCustomer getSalaryCustomer) {
        var doc = DocumentRequest.builder().document(this.customerDocument).build();
        checkDocumentCustomer.execute(doc);
        BigDecimal salary = getSalaryCustomer.execute(doc.getDocument());
        BigDecimal limit = getLimit(salary);
        setLimit(limit);
        createAccount.execute(this);
        deposit(new BigDecimal("100.00"), sendToTransactionTopc);
    }

    private BigDecimal getLimit(BigDecimal salary) {
        BigDecimal dezMil = new BigDecimal("10000");
        BigDecimal quinzeMil = new BigDecimal("15000");
        BigDecimal vinteMil = new BigDecimal("20000");

        BigDecimal multiplicador = BigDecimal.ZERO;
        if (salary.compareTo(dezMil) < 0) {
            multiplicador = new BigDecimal("0.01");
        } else if (salary.compareTo(dezMil) >= 0 && salary.compareTo(quinzeMil) <= 0) {
            multiplicador = new BigDecimal("0.03");
        } else if (salary.compareTo(vinteMil) >= 0) {
            multiplicador = (new BigDecimal("0.05"));
        }

        System.out.println("salario " + salary);
        System.out.println("multiplicador " + multiplicador);

        BigDecimal limit = salary.multiply(multiplicador);
        System.out.println("limit " + limit);
        return limit;
    }

    public void deposit(BigDecimal amount, ISendToTransactionTopc sendToTransactionTopc){
        this.balance = this.balance.add(amount);
        TransactionRequest transactionRequest = TransactionRequest.builder()
                .originAccountAgency(this.agency)
                .destinationAccountNumber(this.number)
                .balance(this.balance)
                .instantTransaction(this.created_at)
                .build();
        sendToTransactionTopc.execute(transactionRequest);
    }

    public void withdraw(BigDecimal amount) throws BalanceToWithdrawException {
        if (this.balance.compareTo(amount) >= 0){
            this.balance.subtract(amount);
        }else {
            throw new BalanceToWithdrawException("error withdraw");
        }
    }
}
