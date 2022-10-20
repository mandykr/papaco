package com.papaco.papacoapigateway.account.application;

import com.papaco.papacoapigateway.account.domain.Outbox;
import com.papaco.papacoapigateway.account.domain.repository.OutboxRepository;
import com.papaco.papacoapigateway.account.application.message.AccountProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class CDCService {
    private final OutboxRepository outboxRepository;
    private final AccountProducer accountProducer;

    @Value("${cdc.batch_size}")
    private int batchSize;

    @Scheduled(fixedDelayString = "${cdc.polling_ms}")
    public void sendAccountEvent() {
        List<Outbox> outboxes = outboxRepository.findAllByOrderByIdAsc(Pageable.ofSize(batchSize)).toList();
        accountProducer.send(outboxes);
        outboxRepository.deleteAllInBatch(outboxes);
    }
}
