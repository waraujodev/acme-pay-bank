package br.com.acmepay.adapters.output;

import br.com.acmepay.adapters.output.entity.NotificationEntity;
import br.com.acmepay.adapters.output.repository.NotificationRepository;
import br.com.acmepay.application.domain.model.NotificationDomain;
import br.com.acmepay.application.ports.out.IRegisterNotification;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegisterNotificationService implements IRegisterNotification {

    private final NotificationRepository notificationRepository;

    @Override
    public void register(NotificationDomain notificationDomain) {
        NotificationEntity notificationEntity = NotificationEntity.builder()
                .document(notificationDomain.getDocument())
                .status(notificationDomain.getStatus())
                .createdAt(notificationDomain.getCreatedAt())
                .build();
        notificationRepository.save(notificationEntity);
    }

}
