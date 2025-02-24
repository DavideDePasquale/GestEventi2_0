package com.epicode.GestEventi2_0.repository;

import com.epicode.GestEventi2_0.enumeration.ERole;
import com.epicode.GestEventi2_0.model.Ruolo;

import java.util.Optional;

public interface RuoloRepository {
    Optional<Ruolo> findByName(ERole name);
}
