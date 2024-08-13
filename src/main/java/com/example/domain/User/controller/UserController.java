package com.example.domain.User.controller;

import com.example.domain.User.requestBody.UserRequestBody;
import com.example.domain.User.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/sinUp")
    public void sinUp(@RequestBody @Valid UserRequestBody userRequestBody) {
        userService.sinUp(userRequestBody);
    }
    @PostMapping("/logIn")
    public void logIn(@RequestBody @Valid UserRequestBody userRequestBody){
        userService.logIn(userRequestBody);
    }

}
