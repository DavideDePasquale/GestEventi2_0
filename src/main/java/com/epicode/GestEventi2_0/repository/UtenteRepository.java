package com.epicode.GestEventi2_0.repository;

import com.epicode.GestEventi2_0.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente,Long> {
    public Optional<Utente> findByUsername(String username);
    // x la login
    public boolean existsByUsernameAndPassword(String username, String password);
    // per visualizzare alla creazione se l'username è libero (quindi se è presente o no nel db)
    public boolean existsByUsername(String username);
    // per visualizzare alla creazione se la mail è già presente o meno sul db
    public boolean existsByEmail(String email);
}
