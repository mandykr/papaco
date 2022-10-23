package com.papaco.papacoapigateway.account.application.message;

import com.papaco.papacoapigateway.account.domain.Outbox;

import java.util.List;

public interface AccountProducer {
    void send(List<Outbox> outboxes);
}
