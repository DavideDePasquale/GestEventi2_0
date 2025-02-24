package com.epicode.GestEventi2_0.service;

import com.epicode.GestEventi2_0.model.Evento;
import com.epicode.GestEventi2_0.model.Utente;
import com.epicode.GestEventi2_0.payload.EventoDTO;
import com.epicode.GestEventi2_0.payload.mapper.EventoMapperDto;
import com.epicode.GestEventi2_0.repository.EventoRepository;
import com.epicode.GestEventi2_0.repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class EventoService {

    @Autowired
    EventoRepository eventoRepository;
    @Autowired
    UtenteRepository utenteRepository;
    @Autowired
    EventoMapperDto mapper;


    public Evento createEvent(EventoDTO eventoDTO){
        Optional<Utente> organizzatore = utenteRepository.findById(eventoDTO.getOrganizzatore_id());
        if(organizzatore.isEmpty()){
            throw new RuntimeException("Organizzatore non trovato");
        }
        Evento evento = mapper.toEntity(eventoDTO);
        return  eventoRepository.save(evento);
    }
}
