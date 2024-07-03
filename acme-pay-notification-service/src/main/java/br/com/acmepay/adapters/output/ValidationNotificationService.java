package br.com.acmepay.adapters.output;

import br.com.acmepay.adapters.input.api.request.DocumentRequest;
import br.com.acmepay.adapters.output.entity.NotificationEntity;
import br.com.acmepay.adapters.output.queue.ProducerMessage;
import br.com.acmepay.adapters.output.repository.NotificationRepository;
import br.com.acmepay.application.domain.model.NotificationDomain;
import br.com.acmepay.application.ports.out.IValidationNotification;
import br.com.acmepay.config.RabbitConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ValidationNotificationService implements IValidationNotification {

    private final NotificationRepository notificationRepository;
    private final ProducerMessage producerMessage;

    @Override
    public void validated(NotificationDomain notificationDomain) {
        Optional<NotificationEntity> notificationEntityOptional = notificationRepository
                .findByDocumentAndStatus(notificationDomain.getDocument(), "ACTIVATED");
        DocumentRequest documentRequest = DocumentRequest.builder().document(notificationDomain.getDocument()).build();

        if (notificationEntityOptional.isPresent()) {
            producerMessage.publish(RabbitConfig.QUEUE_SUCCESS_DOCUMENT, documentRequest);
        } else {
            producerMessage.publish(RabbitConfig.QUEUE_FAIL_DOCUMENT, documentRequest);
        }
    }
}
