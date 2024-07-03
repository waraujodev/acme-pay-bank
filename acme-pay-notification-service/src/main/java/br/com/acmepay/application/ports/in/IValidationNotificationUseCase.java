package br.com.acmepay.application.ports.in;

import br.com.acmepay.application.domain.model.NotificationDomain;

public interface IValidationNotificationUseCase {
    void validate(NotificationDomain notificationDomain);
}
