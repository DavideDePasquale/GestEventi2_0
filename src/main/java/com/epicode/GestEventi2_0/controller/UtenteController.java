package com.epicode.GestEventi2_0.controller;

import com.epicode.GestEventi2_0.model.Utente;
import com.epicode.GestEventi2_0.payload.UtenteDTO;
import com.epicode.GestEventi2_0.payload.mapper.UtenteMapperDTO;
import com.epicode.GestEventi2_0.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    UtenteService utenteService;
    @Autowired
    UtenteMapperDTO mapper;



    @PostMapping("/register")
    public UtenteDTO registerUser(@RequestBody @Validated UtenteDTO utenteDTO){
        Utente utente = utenteService.createNewUtente(utenteDTO);
        return mapper.toDto(utente);

    }
}
