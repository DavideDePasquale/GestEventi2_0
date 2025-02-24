package com.epicode.GestEventi2_0;


import com.epicode.GestEventi2_0.enumeration.ERole;
import com.epicode.GestEventi2_0.model.Ruolo;
import com.epicode.GestEventi2_0.repository.RuoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RuoloRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            Ruolo userRole = new Ruolo();
            userRole.setName(ERole.ADMIN);
            roleRepository.save(userRole);

            Ruolo adminRole = new Ruolo();
            adminRole.setName(ERole.USER);
            roleRepository.save(adminRole);

            Ruolo organizerRole = new Ruolo();
            organizerRole.setName(ERole.ORGANIZZATORE);
            roleRepository.save(organizerRole);
        }
    }
}