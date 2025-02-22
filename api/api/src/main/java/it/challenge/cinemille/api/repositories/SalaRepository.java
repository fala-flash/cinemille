package it.challenge.cinemille.api.repositories;

import it.challenge.cinemille.api.entities.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Long> {
}

