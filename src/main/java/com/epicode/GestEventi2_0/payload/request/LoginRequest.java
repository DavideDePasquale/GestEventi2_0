package com.epicode.GestEventi2_0.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 6,max = 18)
    private String password;
}
