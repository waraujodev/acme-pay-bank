package br.com.acmepay.application.domain.model;

import br.com.acmepay.application.ports.in.IValidationNotificationUseCase;
import br.com.acmepay.application.ports.out.IRegisterNotification;
import br.com.acmepay.application.ports.out.IValidationNotification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationDomain {
    private Long id;
    private String document;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void register(IRegisterNotification registerNotification) {
        registerNotification.register(this);
    }

    public void validated(IValidationNotification validationNotification) {
        validationNotification.validated(this);
    }

}
