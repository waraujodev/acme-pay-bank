package br.com.acmepay.application.requests;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class TransactionRequest {
    private Integer originAccountNumber;
    private Integer originAccountAgency;

    private Integer destinationAccountNumber;
    private Integer destinationAccountAgency;

    private BigDecimal balance;

    private LocalDateTime instantTransaction;
}
