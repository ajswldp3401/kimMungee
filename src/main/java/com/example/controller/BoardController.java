package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("board")
public class BoardController {
    @GetMapping("/aa")
    public String aa() {
        return "aa";
    }
}
