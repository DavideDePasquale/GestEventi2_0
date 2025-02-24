package com.epicode.GestEventi2_0.service;

import com.epicode.GestEventi2_0.model.Utente;
import com.epicode.GestEventi2_0.payload.UtenteDTO;
import com.epicode.GestEventi2_0.payload.mapper.UtenteMapperDTO;
import com.epicode.GestEventi2_0.repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UtenteService {

    @Autowired
    UtenteRepository utenteRepository;
    @Autowired
    UtenteMapperDTO mapper;
    @Autowired
    PasswordEncoder passwordEncoder;


    public Utente createNewUtente(UtenteDTO utenteDTO){
        Utente utente = mapper.toEntity(utenteDTO);
        utente.setPassword(passwordEncoder.encode(utenteDTO.getPassword()));
        utente.getRoles().forEach(System.out::println);
        return utenteRepository.save(utente);
    }




}
