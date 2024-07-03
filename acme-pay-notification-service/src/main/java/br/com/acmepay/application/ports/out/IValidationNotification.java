package br.com.acmepay.application.ports.out;

import br.com.acmepay.application.domain.model.NotificationDomain;

public interface IValidationNotification {
    void validated(NotificationDomain notificationDomain);
}
