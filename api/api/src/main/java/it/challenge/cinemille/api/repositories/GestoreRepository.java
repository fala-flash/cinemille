package it.challenge.cinemille.api.repositories;

import it.challenge.cinemille.api.entities.Gestore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestoreRepository extends JpaRepository<Gestore, Long> {
    Gestore findByUsername(String username);
}

