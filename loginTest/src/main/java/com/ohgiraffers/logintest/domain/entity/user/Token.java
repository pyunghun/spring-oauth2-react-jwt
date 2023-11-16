package com.ohgiraffers.logintest.domain.entity.user;


import com.ohgiraffers.logintest.domain.entity.time.DefaultTime;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;


@Getter
@Table(name="token")
@Entity
public class Token extends DefaultTime {

    @Id
    @Column(name = "user_email", length = 1024 , nullable = false)
    private String userEmail;

    @Column(name = "refresh_token", length = 1024 , nullable = false)
    private String refreshToken;

    public Token(){}

    public Token updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    @Builder
    public Token(String userEmail, String refreshToken) {
        this.userEmail = userEmail;
        this.refreshToken = refreshToken;
    }
}
