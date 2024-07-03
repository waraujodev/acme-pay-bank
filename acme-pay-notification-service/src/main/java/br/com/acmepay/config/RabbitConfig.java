package br.com.acmepay.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String EXCHANGE_CHECK_DOCUMENT = "check_document_queue_exchange";
    public static final String EXCHANGE_CHECK_DOCUMENT_SUCCESS = "check_document_queue_exchange_success";
    public static final String EXCHANGE_CHECK_DOCUMENT_FAIL = "check_document_queue_exchange_fail";

    public static final String QUEUE_CHECK_DOCUMENT = "queue_check_document";
    public static final String QUEUE_SUCCESS_DOCUMENT = "queue_success_document";
    public static final String QUEUE_FAIL_DOCUMENT = "queue_fail_document";

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
