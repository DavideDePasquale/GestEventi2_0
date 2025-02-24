package com.epicode.GestEventi2_0.controller;

import com.epicode.GestEventi2_0.model.Evento;
import com.epicode.GestEventi2_0.payload.EventoDTO;
import com.epicode.GestEventi2_0.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    EventoService eventoService;


    @PostMapping("/new")
    @PreAuthorize("hasRole('ADMIN')")
    public Evento createEvento(@RequestBody @Validated EventoDTO eventoDTO){
        return eventoService.createEvent(eventoDTO);
    }

}
