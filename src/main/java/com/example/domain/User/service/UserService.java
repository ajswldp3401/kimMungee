package com.example.domain.User.service;

import com.example.domain.User.entity.User;
import com.example.domain.User.exception.SinUpException;
import com.example.domain.User.repository.UserRepository;
import com.example.domain.User.requestBody.UserRequestBody;
import com.example.global.jwt.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    public void sinUp(UserRequestBody userRequestBody)throws RuntimeException{
        if(userRepository.findByName(userRequestBody.getName()).isEmpty()){
            throw new SinUpException("똑같은 이름이 있습니다.");
        }
        User user = User.builder()
                .name(userRequestBody.getName())
                .password(passwordEncoder.encode(userRequestBody.getPassword()))
                .build();
        userRepository.save(user);
    }
    public void logIn(UserRequestBody userRequestBody)throws RuntimeException{
        if(passwordEncoder.matches(
                userRepository.findByName(userRequestBody.getName()).get(0).getPassword()
                , userRequestBody.getPassword())) {
            String token = jwtUtil.createToken(userRequestBody.getName());

        }

    }
}
