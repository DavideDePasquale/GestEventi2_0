package com.epicode.GestEventi2_0.service;

import com.epicode.GestEventi2_0.repository.PrenotazioneRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PrenotazioneService {

    @Autowired
    PrenotazioneRepository prenotazioneRepository;
}
