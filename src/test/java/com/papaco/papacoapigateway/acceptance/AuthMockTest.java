package com.papaco.papacoapigateway.acceptance;

import com.papaco.papacoapigateway.account.application.AccountService;
import com.papaco.papacoapigateway.account.ui.AccountApiController;
import com.papaco.papacoapigateway.auth.oauth.CustomOAuth2UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.oauth2Login;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AccountApiController.class)
@MockBeans({
        @MockBean(JpaMetamodelMappingContext.class),
        @MockBean(CustomOAuth2UserService.class),
        @MockBean(AccountService.class)
})
class AuthMockTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void token() throws Exception {
        ResultActions result = mockMvc.perform(get("/auth/94955454")
                .with(oauth2Login()
                        .authorities(new SimpleGrantedAuthority("ROLE_USER"))
                        .attributes(attributes -> {
                            attributes.put("userKey", "94955454");
                            attributes.put("name", "mandykr");
                            attributes.put("email", "mandykr@gmail.com");
                        })
                ));
        result.andDo(print())
                .andExpect(status().isOk());
    }
}
