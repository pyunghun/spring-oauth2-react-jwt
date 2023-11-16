package com.ohgiraffers.logintest.service.user;


import com.ohgiraffers.logintest.advice.assertThat.DefaultAssert;
import com.ohgiraffers.logintest.config.security.token.UserPrincipal;
import com.ohgiraffers.logintest.domain.entity.user.User;
import com.ohgiraffers.logintest.payload.response.ApiResponse;
import com.ohgiraffers.logintest.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public ResponseEntity<?> readByUser(UserPrincipal userPrincipal){
        Optional<User> user = userRepository.findById(userPrincipal.getId());
        DefaultAssert.isOptionalPresent(user);
        ApiResponse apiResponse = ApiResponse.builder().check(true).information(user.get()).build();
        return ResponseEntity.ok(apiResponse);
    }
}
