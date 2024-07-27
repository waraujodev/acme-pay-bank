package br.com.acmepay.adapters.output.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "accounts", schema = "account_service")
public class AccountEntity {

    @Id
    @SequenceGenerator(name = "account_service.account_seq",
    sequenceName = "account_service.account_seq",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "account_service.account_seq")
    private Long id;

    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private Boolean close;
    @Column(name = "LIMIT_ACCOUNT")
    private BigDecimal limit;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
