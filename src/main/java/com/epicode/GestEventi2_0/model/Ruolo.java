package com.epicode.GestEventi2_0.model;

import com.epicode.GestEventi2_0.enumeration.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ruoli")
public class Ruolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, unique = true)
    private ERole name; // ENUM

    @OneToMany(mappedBy = "ruolo", fetch = FetchType.LAZY)
    private List<Utente> utenti = new ArrayList<>();

    @Override
    public String toString() {
        return "Role{id=" + id + ", name=" + name + "}";
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
