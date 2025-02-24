package com.epicode.GestEventi2_0.controller;

import com.epicode.GestEventi2_0.model.Utente;
import com.epicode.GestEventi2_0.payload.UtenteDTO;
import com.epicode.GestEventi2_0.payload.mapper.UtenteMapperDTO;
import com.epicode.GestEventi2_0.payload.request.LoginRequest;
import com.epicode.GestEventi2_0.service.AuthService;
import com.epicode.GestEventi2_0.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utente")
public class UtenteController {

    private final AuthService authService;
    private final UtenteService utenteService;
    private final UtenteMapperDTO mapper;

    @Autowired
    public UtenteController(AuthService authService, UtenteService utenteService, UtenteMapperDTO mapper) {
        this.authService = authService;
        this.utenteService = utenteService;
        this.mapper = mapper;
    }

    @PostMapping("/register")
    public UtenteDTO registerUser(@RequestBody @Validated UtenteDTO utenteDTO) {
        Utente utente = utenteService.createNewUtente(utenteDTO);
        return mapper.toDto(utente);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Validated LoginRequest loginRequest) {
        return authService.authenticateUser(loginRequest);
    }
}
