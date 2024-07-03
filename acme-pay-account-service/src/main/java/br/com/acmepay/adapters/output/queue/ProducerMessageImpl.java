package br.com.acmepay.adapters.output.queue;

import br.com.acmepay.adapters.input.api.request.DocumentRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static br.com.acmepay.config.RabbitConfig.QUEUE_CHECK_DOCUMENT;

@Service
@AllArgsConstructor
@Slf4j
public class ProducerMessageImpl implements ProducerMessage {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publish(DocumentRequest documentRequest) {
        log.info("Publishing : Payload {} / Queue {}", documentRequest, QUEUE_CHECK_DOCUMENT);
        this.rabbitTemplate.convertAndSend(QUEUE_CHECK_DOCUMENT, documentRequest.getDocument());
        log.info("Published : Payload {} / Queue {}", documentRequest, QUEUE_CHECK_DOCUMENT);
    }
}
