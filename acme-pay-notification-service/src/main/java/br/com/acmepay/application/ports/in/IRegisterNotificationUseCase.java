package br.com.acmepay.application.ports.in;

import br.com.acmepay.application.domain.model.NotificationDomain;

public interface IRegisterNotificationUseCase {
    void register(NotificationDomain domain);
}
