package it.challenge.cinemille.api.repositories;

import it.challenge.cinemille.api.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}

