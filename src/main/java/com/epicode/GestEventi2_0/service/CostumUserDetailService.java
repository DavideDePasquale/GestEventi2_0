package com.epicode.GestEventi2_0.service;

import com.epicode.GestEventi2_0.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CostumUserDetailService implements UserDetailsService {



    private  UtenteRepository utenteRepository;


    public CostumUserDetailService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      UserDetails dettagli = (UserDetails) utenteRepository.findByUsername(username)
              .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato"));
        return dettagli;
    }
}
