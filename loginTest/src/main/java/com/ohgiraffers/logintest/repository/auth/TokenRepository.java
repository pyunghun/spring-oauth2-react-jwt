package com.ohgiraffers.logintest.repository.auth;


import com.ohgiraffers.logintest.domain.entity.user.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByUserEmail(String userEmail);
    Optional<Token> findByRefreshToken(String refreshToken);
}