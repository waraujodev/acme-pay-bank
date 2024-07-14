package br.com.acmepay.application.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    private Integer originAccountNumber;
    private Integer originAccountAgency;

    private Integer destinationAccountNumber;
    private Integer destinationAccountAgency;

    private BigDecimal balance;

    private LocalDateTime instantTransaction;
}
