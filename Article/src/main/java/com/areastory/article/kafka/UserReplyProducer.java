package com.areastory.article.kafka;

import com.areastory.article.config.properties.KafkaProperties;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserReplyProducer {
    private final KafkaTemplate<Long, Long> userReplyTemplate;
    private final KafkaProperties kafkaProperties;
    public void send(Long userId) {
        userReplyTemplate.send(new ProducerRecord<>(kafkaProperties.getType().getUserReply(), userId, userId));
    }
}
