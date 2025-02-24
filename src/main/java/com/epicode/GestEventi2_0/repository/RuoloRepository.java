package com.epicode.GestEventi2_0.repository;

import com.epicode.GestEventi2_0.enumeration.ERole;
import com.epicode.GestEventi2_0.model.Ruolo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RuoloRepository  extends JpaRepository<Ruolo,Long> {
    Optional<Ruolo> findByName(ERole name);
}
