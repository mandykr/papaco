package com.papaco.papacoapigateway.account.infra;

import com.papaco.papacoapigateway.account.domain.Outbox;
import com.papaco.papacoapigateway.account.application.message.AccountProducer;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class AccountSQSProducer implements AccountProducer {
    private final QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    @Transactional
    @Override
    public void send(List<Outbox> outboxes) {
        outboxes.forEach(outbox -> {
            Message<String> message = MessageBuilder.withPayload(outbox.getPayload())
                    .setHeader("message-group-id", String.valueOf(outbox.getAggregateId()))
                    .setHeader("message-deduplication-id", String.valueOf(outbox.getId()))
                    .build();

            // 아웃박스 패턴 장점: send 오류가 발생해도 outbox 테이블에 데이터가 남아있다
//            Message<String> message = MessageBuilder.withPayload(outbox.getPayload())
//                    .setHeader("message-group-id", outbox.getAggregateId())
//                    .setHeader("message-deduplication-id", outbox.getId())
//                    .build();

            queueMessagingTemplate.send(endpoint, message);
            log.info("Message: {}, {}, {}", outbox.getAggregateId(), outbox.getId(), message);
        });
    }
}
