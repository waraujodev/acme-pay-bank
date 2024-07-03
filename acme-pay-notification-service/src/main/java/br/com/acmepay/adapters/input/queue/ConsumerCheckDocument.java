package br.com.acmepay.adapters.input.queue;

import br.com.acmepay.adapters.input.api.request.DocumentRequest;
import br.com.acmepay.application.domain.model.NotificationDomain;
import br.com.acmepay.application.ports.in.IValidationNotificationUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import static br.com.acmepay.config.RabbitConfig.QUEUE_CHECK_DOCUMENT;

@Service
@AllArgsConstructor
@Slf4j
public class ConsumerCheckDocument {

    private final IValidationNotificationUseCase validationNotificationUseCase;

    @RabbitListener(queues = {QUEUE_CHECK_DOCUMENT})
    public void consumer(@Payload DocumentRequest documentRequest) {
        log.info("Message {} ", documentRequest);
        NotificationDomain notificationDomain = NotificationDomain.builder()
                .document(documentRequest.getDocument())
                .build();
        validationNotificationUseCase.validate(notificationDomain);
    }
}
