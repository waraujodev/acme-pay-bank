package br.com.acmepay.adapters.output.queue;

import br.com.acmepay.adapters.input.api.request.DocumentRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProducerMessageImpl implements ProducerMessage {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publish(String routingKey, DocumentRequest documentRequest) {
        log.info("Publishing : Payload {} / Queue {}", documentRequest, routingKey);
        this.rabbitTemplate.convertAndSend(routingKey, documentRequest);
        log.info("Published : Payload {} / Queue {}", documentRequest, routingKey);
    }
}
