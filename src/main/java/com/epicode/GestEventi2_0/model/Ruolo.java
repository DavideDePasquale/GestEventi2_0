package com.epicode.GestEventi2_0.model;

import com.epicode.GestEventi2_0.enumeration.ERole;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Utente> users = new HashSet<>();

    @Override
    public String toString() {
        return "Role{id=" + id + ", name=" + name + "}";
    }

    public String getName() {
        return name.name();
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
