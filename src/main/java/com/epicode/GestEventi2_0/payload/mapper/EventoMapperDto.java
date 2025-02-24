package com.epicode.GestEventi2_0.payload.mapper;

import com.epicode.GestEventi2_0.model.Evento;
import com.epicode.GestEventi2_0.model.Utente;
import com.epicode.GestEventi2_0.payload.EventoDTO;
import com.epicode.GestEventi2_0.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventoMapperDto {

    @Autowired
    UtenteRepository repository;

    public EventoDTO toDto(Evento entity){
        EventoDTO dto = new EventoDTO();
        dto.setTitolo(entity.getTitolo());
        dto.setCapacita(entity.getCapacita());
        dto.setCitta(entity.getCitta());
        dto.setDataevento(entity.getDataevento());
        dto.setLuogo(entity.getLuogo());
        dto.setDescrizione(entity.getDescrizione());
        dto.setOrganizzatore_id(entity.getOrganizzatore().getIdutente());
        return dto;
    }

    public Evento toEntity(EventoDTO dto){
        Evento entity = new Evento();
        entity.setTitolo(dto.getTitolo());
        entity.setCapacita(dto.getCapacita());
        entity.setCitta(dto.getCitta());
        entity.setDataevento(dto.getDataevento());
        entity.setLuogo(dto.getLuogo());
        entity.setDescrizione(dto.getDescrizione());
        Utente utente = repository.findById(dto.getOrganizzatore_id()).orElseThrow(()-> new RuntimeException("Utente non trovato"))
        entity.setOrganizzatore(utente);
        return entity;
    }
}
