package br.com.acmepay.adapters.input;

import br.com.acmepay.adapters.input.api.request.DocumentRequest;
import br.com.acmepay.adapters.input.api.response.NotificationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/api/v1/notifications/")
public interface INotificationResourceAPI {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("register")
    NotificationResponse register(@RequestBody DocumentRequest request);
}
