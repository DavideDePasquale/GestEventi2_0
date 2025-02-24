package com.epicode.GestEventi2_0.payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UtenteDTO {

    @NotBlank
    private String nome;
    @NotBlank
    private String cognome;
    @NotBlank
    private String email;
    @NotBlank
    private String username;
    @NotBlank
    @Size(min = 6, max = 18)
    private String password;
    private String ruolo;
}
