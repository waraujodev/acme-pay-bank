package br.com.acmepay.adapters.output.repository;

import br.com.acmepay.adapters.output.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
    Optional<NotificationEntity> findByDocumentAndStatus(String document, String status);
}
