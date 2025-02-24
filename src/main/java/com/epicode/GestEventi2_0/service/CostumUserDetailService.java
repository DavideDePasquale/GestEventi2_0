package com.epicode.GestEventi2_0.service;

import com.epicode.GestEventi2_0.model.Utente;
import com.epicode.GestEventi2_0.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class CostumUserDetailService implements UserDetailsService {


    private  UtenteRepository utenteRepository;

    @Autowired
    public CostumUserDetailService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utente user = utenteRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato"));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
               new ArrayList<>()
               // Collections.singletonList(new SimpleGrantedAuthority(user.getRuolo().getName()))
        );
    }
}
