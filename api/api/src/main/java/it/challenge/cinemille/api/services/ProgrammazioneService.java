package it.challenge.cinemille.api.services;

import it.challenge.cinemille.api.entities.Programmazione;
import it.challenge.cinemille.api.repositories.ProgrammazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProgrammazioneService {

    @Autowired
    private ProgrammazioneRepository programmazioneRepository;

    public List<Programmazione> getProgrammazioniByDate(Date dataInizio, Date dataFine) {
        return programmazioneRepository.findByDateRange(dataInizio, dataFine);
    }
}

