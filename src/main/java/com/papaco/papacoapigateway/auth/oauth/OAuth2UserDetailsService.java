package com.papaco.papacoapigateway.auth.oauth;

import java.util.Map;

public interface OAuth2UserDetailsService {
    OAuth2UserDetails saveOrUpdateAccount(Map<String, Object> accountAttributes);
}
