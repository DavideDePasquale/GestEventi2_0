package com.epicode.GestEventi2_0.repository;

import com.epicode.GestEventi2_0.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento,Long> {
}
