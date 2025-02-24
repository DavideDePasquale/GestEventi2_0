package com.epicode.GestEventi2_0.payload.mapper;

import com.epicode.GestEventi2_0.enumeration.ERole;
import com.epicode.GestEventi2_0.model.Ruolo;
import com.epicode.GestEventi2_0.model.Utente;
import com.epicode.GestEventi2_0.payload.UtenteDTO;
import com.epicode.GestEventi2_0.repository.EventoRepository;
import com.epicode.GestEventi2_0.repository.RuoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UtenteMapperDTO {

    @Autowired
    RuoloRepository repository;


    public UtenteDTO toDto(Utente entity){
        UtenteDTO dto = new UtenteDTO();
        dto.setNome(entity.getNome());
        dto.setCognome(entity.getCognome());
        dto.setEmail(entity.getEmail());
        dto.setRuolo(entity.getRuolo().toString());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    public Utente toEntity(UtenteDTO dto){
        Utente entity = new Utente();
        entity.setNome(dto.getNome());
        entity.setCognome(dto.getCognome());
        entity.setEmail(dto.getEmail());
        Ruolo ruolo = repository.findByName(ERole.valueOf(dto.getRuolo())).orElseThrow(()-> new RuntimeException("Ruolo non trovato"));
        entity.setRuolo(ruolo);
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        return entity;
    }
}
