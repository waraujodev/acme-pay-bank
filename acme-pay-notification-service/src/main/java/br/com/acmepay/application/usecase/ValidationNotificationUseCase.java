package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.model.NotificationDomain;
import br.com.acmepay.application.ports.in.IValidationNotificationUseCase;
import br.com.acmepay.application.ports.out.IValidationNotification;
import br.com.acmepay.application.util.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class ValidationNotificationUseCase implements IValidationNotificationUseCase {

    private IValidationNotification validationNotification;

    @Override
    public void validate(NotificationDomain domain) {
        domain.validated(validationNotification);
    }
}
