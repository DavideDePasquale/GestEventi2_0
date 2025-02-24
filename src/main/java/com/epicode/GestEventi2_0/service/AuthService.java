package com.epicode.GestEventi2_0.service;

import com.epicode.GestEventi2_0.payload.request.LoginRequest;
import com.epicode.GestEventi2_0.security.jwt.JwtUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    // qui dentro ci passiamo i dati (username e password)
    // questo service deve autenticare se l'utente c'è o meno.
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;


    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
        System.out.println("AUTHENTICATING USER : " + loginRequest.getUsername());
        Authentication authentication;
        try {
//            authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            loginRequest.getUsername(), loginRequest.getPassword()));

        } catch (RuntimeException e) {
            System.out.println("AUTHENTICATION FAILED : " + loginRequest.getUsername());
            throw new RuntimeException(e);
        }
        System.out.println("USER AUTHENTICATION SUCCESSFULLY : " + loginRequest.getUsername());

        // prende l'oggetto autenticato e lo rendiamo sicuro.  ⬇️
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
//        String ruolo = authentication.getAuthorities().toString();
        //String jwt = jwtUtils.generateToken(username, ruolo);
//        System.out.println("JWT GENERATE : " + username);
        return ResponseEntity.ok("CIAO");
    }
}
