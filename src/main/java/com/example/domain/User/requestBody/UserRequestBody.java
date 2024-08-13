package com.example.domain.User.requestBody;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter

public class UserRequestBody {
    @NotBlank
    String name;

    @NotBlank
    String password;
}
