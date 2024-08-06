package com.example.controller;

import com.example.requestBody.SinUpRequestBody;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final UserService userService;


    @PostMapping("/a")
    public void sinUp(@RequestBody SinUpRequestBody sinUpRequestBody) {
        userService.sinUp(sinUpRequestBody);
    }

    @GetMapping("/aa")
    public String aa() {
        return "aa";
    }
}
