package com.papaco.papacoapigateway.unit.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.papaco.papacoapigateway.account.domain.Account;
import com.papaco.papacoapigateway.account.domain.Outbox;
import com.papaco.papacoapigateway.account.domain.event.AccountCreatedEvent;
import com.papaco.papacoapigateway.account.domain.event.EventType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class OutboxTest {
    @DisplayName("outbox를 생성한다")
    @Test
    void create() {
        Account account = Account.create("123456789", "mandykr", "mandykr@gmail.com");
        ObjectMapper objectMapper = new ObjectMapper();

        assertThatCode(() -> {
            String payload = objectMapper.writeValueAsString(AccountCreatedEvent.of(account));
            new Outbox(1L, Account.class.getName(), EventType.CREATED, payload);
        }).doesNotThrowAnyException();
    }
}
