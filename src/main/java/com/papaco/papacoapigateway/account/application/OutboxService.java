package com.papaco.papacoapigateway.account.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.papaco.papacoapigateway.account.domain.Outbox;
import com.papaco.papacoapigateway.account.domain.event.AccountEvent;
import com.papaco.papacoapigateway.account.domain.repository.OutboxRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRES_NEW) // 이벤트 발행에서 트랜잭션이 커밋(종료)되었기 떄문에 새로운 트랜잭션 시작
@Service
public class OutboxService {
    private final OutboxRepository outboxRepository;
    private final ObjectMapper objectMapper;

    @TransactionalEventListener // 이벤트 발행 트랜잭션이 커밋되면 동작
    public void saveOutbox(AccountEvent accountEvent) {

        String payload = null;
        try {
            payload = objectMapper.writeValueAsString(accountEvent);
            log.info("accountEvent={}", payload);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Outbox outbox = new Outbox(accountEvent.getId(), accountEvent.getClass().getSimpleName(), accountEvent.getEventType(), payload);
        outboxRepository.save(outbox);
    }
}
