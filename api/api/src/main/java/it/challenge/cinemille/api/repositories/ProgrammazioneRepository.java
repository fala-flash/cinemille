package it.challenge.cinemille.api.repositories;

import it.challenge.cinemille.api.entities.Programmazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ProgrammazioneRepository extends JpaRepository<Programmazione, Long> {

    @Query("SELECT p FROM Programmazione p WHERE (:dataInizio IS NULL OR p.dataInizio >= :dataInizio) AND (:dataFine IS NULL OR p.dataFine <= :dataFine)")
    List<Programmazione> findByDateRange(@Param("dataInizio") Date dataInizio, @Param("dataFine") Date dataFine);
}

