package com.epicode.GestEventi2_0.payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UtenteDTO {


    private String nome;

    private String cognome;

    private String email;

    private String username;

    private String password;

    private Set<String> ruolo = new HashSet<>();
}
