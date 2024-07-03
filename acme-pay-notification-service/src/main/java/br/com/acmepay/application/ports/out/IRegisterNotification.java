package br.com.acmepay.application.ports.out;

import br.com.acmepay.application.domain.model.NotificationDomain;

public interface IRegisterNotification {
    void register(NotificationDomain notificationDomain);
}
