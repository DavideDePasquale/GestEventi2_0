package com.epicode.GestEventi2_0.payload.mapper;

import com.epicode.GestEventi2_0.enumeration.ERole;
import com.epicode.GestEventi2_0.model.Ruolo;
import com.epicode.GestEventi2_0.model.Utente;
import com.epicode.GestEventi2_0.payload.UtenteDTO;
import com.epicode.GestEventi2_0.repository.EventoRepository;
import com.epicode.GestEventi2_0.repository.RuoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UtenteMapperDTO {


   public RuoloRepository repository;

   @Autowired
    public UtenteMapperDTO(RuoloRepository repository) {
        this.repository = repository;
    }

    public UtenteDTO toDto(Utente entity){
        UtenteDTO dto = new UtenteDTO();
        dto.setNome(entity.getNome());
        dto.setCognome(entity.getCognome());
        dto.setEmail(entity.getEmail());
        Set<String> roles = new HashSet<>();

        for (Ruolo roleName : entity.getRoles()) {
            Ruolo role = repository.findByName(ERole.valueOf(String.valueOf(roleName)))
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
            roles.add(role.toString());
        }
        dto.setRuolo(roles);
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    public Utente toEntity(UtenteDTO dto){
        Utente entity = new Utente();
        entity.setNome(dto.getNome());
        entity.setCognome(dto.getCognome());
        entity.setEmail(dto.getEmail());
        Set<Ruolo> roles = new HashSet<>();

        for (String roleName : dto.getRuolo()) {
            Ruolo role = repository.findByName(ERole.valueOf(roleName))
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
            roles.add(role);
        }
        entity.setRoles(roles);
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        return entity;
    }

}
