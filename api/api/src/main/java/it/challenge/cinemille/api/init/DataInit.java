package it.challenge.cinemille.api.init;

import it.challenge.cinemille.api.entities.Film;
import it.challenge.cinemille.api.entities.Sala;
import it.challenge.cinemille.api.entities.Programmazione;
import it.challenge.cinemille.api.entities.Gestore;
import it.challenge.cinemille.api.models.Tecnologia;
import it.challenge.cinemille.api.repositories.FilmRepository;
import it.challenge.cinemille.api.repositories.SalaRepository;
import it.challenge.cinemille.api.repositories.ProgrammazioneRepository;
import it.challenge.cinemille.api.repositories.GestoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DataInit implements CommandLineRunner {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private ProgrammazioneRepository programmazioneRepository;

    @Autowired
    private GestoreRepository gestoreRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Inizializza  film
        Film film1 = new Film("Film Uno", sdf.parse("2025-01-01"), 120);
        Film film2 = new Film("Film Due", sdf.parse("2025-02-01"), 90);
        filmRepository.save(film1);
        filmRepository.save(film2);

        // Inizializza sale
        Sala sala1 = new Sala(1, 250, Tecnologia.IMAX);
        Sala sala2 = new Sala(2, 150, Tecnologia.STANDARD);
        Sala sala3 = new Sala(3, 50, Tecnologia.STANDARD);
        salaRepository.save(sala1);
        salaRepository.save(sala2);
        salaRepository.save(sala3);

        // Inizializza un gestore
        Gestore gestore = new Gestore("admin", "admin123");
        gestoreRepository.save(gestore);

        // Inizializza programmazioni
        Date start1 = sdf.parse("2025-02-23");
        Date end1 = sdf.parse("2025-03-05");
        Programmazione prog1 = new Programmazione(start1, end1, film1, sala1);

        Date start2 = sdf.parse("2025-01-01");
        Date end2 = sdf.parse("2025-01-8");
        Programmazione prog2 = new Programmazione(start2, end2, film2, sala2);

        programmazioneRepository.save(prog1);
        programmazioneRepository.save(prog2);
    }
}

