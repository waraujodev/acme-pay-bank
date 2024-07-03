package br.com.acmepay.adapters.output.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "notification", schema = "notification_service")
public class NotificationEntity {

    @Id
    @SequenceGenerator(name = "notification_service.notification_seq",
            sequenceName = "notification_service.notification_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "notification_service.notification_seq")
    private Long id;
    private String document;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
