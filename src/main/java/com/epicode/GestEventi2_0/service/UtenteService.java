package com.epicode.GestEventi2_0.service;

import com.epicode.GestEventi2_0.model.Utente;
import com.epicode.GestEventi2_0.payload.UtenteDTO;
import com.epicode.GestEventi2_0.payload.mapper.UtenteMapperDTO;
import com.epicode.GestEventi2_0.repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Utente getUtenteById(Long id){
       return utenteRepository.findById(id).orElseThrow(()-> new RuntimeException("Utente con id " + id + " non presente nel db"));

    }
    public List<Utente> getAllUtenti(){
        return utenteRepository.findAll();
    }




}
