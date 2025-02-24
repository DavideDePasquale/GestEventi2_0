package com.epicode.GestEventi2_0.payload;

import com.epicode.GestEventi2_0.model.Utente;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EventoDTO {

    @NotBlank
    private String descrizione;
    @NotBlank
    private LocalDate dataevento;
    @NotBlank
    private String luogo;
    @NotBlank
    private String citta;
    @NotBlank
    private int capacita;
    @NotBlank
    private Long organizzatore_id;

}
