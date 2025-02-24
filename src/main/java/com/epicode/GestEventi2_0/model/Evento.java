package com.epicode.GestEventi2_0.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idevento;
    @Column(nullable = true)
    private String descrizione;
    @Column(nullable = false)
    private LocalDate dataevento;
    @Column(nullable = false)
    private String luogo;
    @Column(nullable = false)
    private String citta;
    @Column(nullable = false)
    private int capacita;
    @ManyToOne
    @JoinColumn(name = "organizzatore_id")
    private Utente organizzatore;


}
