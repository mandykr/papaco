package com.papaco.papacoapigateway.acceptance.auth;

import com.papaco.papacoapigateway.acceptance.AcceptanceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.papaco.papacoapigateway.acceptance.auth.AuthAcceptanceSteps.*;

class AuthAcceptanceTest extends AcceptanceTest {
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    void oAuth() {
        String location = 로그인_페이지_요청();
    }
}
