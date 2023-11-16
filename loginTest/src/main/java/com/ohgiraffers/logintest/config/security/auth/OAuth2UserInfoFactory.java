package com.ohgiraffers.logintest.config.security.auth;



import com.ohgiraffers.logintest.advice.assertThat.DefaultAssert;
import com.ohgiraffers.logintest.config.security.auth.company.Kakao;
import com.ohgiraffers.logintest.domain.entity.user.Provider;

import java.util.Map;

public class OAuth2UserInfoFactory {
    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(Provider.kakao.toString())) {
            return new Kakao(attributes);
        } else {
            DefaultAssert.isAuthentication("해당 oauth2 기능은 지원하지 않습니다.");
        }
        return null;
    }
}
