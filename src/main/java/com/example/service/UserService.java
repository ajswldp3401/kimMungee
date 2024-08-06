package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.requestBody.SinUpRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void sinUp(SinUpRequestBody sinUpRequestBody){

        User user = User.builder()
                .name(sinUpRequestBody.getName())
                .password(sinUpRequestBody.getPassword())
                .build();
        userRepository.save(user);
    }
}
