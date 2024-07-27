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
@Table(name = "customers", schema = "customer_service")
public class CustommerEntity {

    @Id
    @SequenceGenerator(name = "customer_service.customer_seq",
            sequenceName = "customer_service.customer_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "customer_service.customer_seq")
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    private BigDecimal salary;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
