package com.example.requestBody;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class SinUpRequestBody {
    @NotBlank
    String name;

    @NotBlank
    String password;
}
