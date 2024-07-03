package br.com.acmepay.adapters.input.api.controller;

import br.com.acmepay.adapters.input.INotificationResourceAPI;
import br.com.acmepay.adapters.input.api.request.DocumentRequest;
import br.com.acmepay.adapters.input.api.response.NotificationResponse;
import br.com.acmepay.application.domain.model.NotificationDomain;
import br.com.acmepay.application.ports.in.IRegisterNotificationUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class NotificationController implements INotificationResourceAPI {

    private final IRegisterNotificationUseCase registerNotificationUseCase;

    @Override
    public NotificationResponse register(DocumentRequest request) {
        NotificationDomain notificationDomain = NotificationDomain.builder()
                .document(request.getDocument())
                .status("SUSPENDED")
                .createdAt(LocalDateTime.now())
                .build();
        registerNotificationUseCase.register(notificationDomain);
        return NotificationResponse.builder()
                .message("notification registered!")
                .build();
    }
}
