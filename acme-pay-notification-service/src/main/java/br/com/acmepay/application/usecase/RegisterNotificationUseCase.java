package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.model.NotificationDomain;
import br.com.acmepay.application.ports.in.IRegisterNotificationUseCase;
import br.com.acmepay.application.ports.out.IRegisterNotification;
import br.com.acmepay.application.util.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class RegisterNotificationUseCase implements IRegisterNotificationUseCase {

    private IRegisterNotification registerNotification;

    @Override
    public void register(NotificationDomain domain) {
        domain.register(registerNotification);
    }
}
