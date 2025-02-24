package com.epicode.GestEventi2_0.payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UtenteDTO {


    private String nome;

    private String cognome;

    private String email;

    private String username;

    private String password;
    private String ruolo;
}
