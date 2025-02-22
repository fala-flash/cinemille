package it.challenge.cinemille.api.controllers;

import it.challenge.cinemille.api.entities.Programmazione;
import it.challenge.cinemille.api.services.AuthService;
import it.challenge.cinemille.api.services.ProgrammazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Calendar;

@RestController
@RequestMapping("/api")
public class ProgrammazioneController {

    @Autowired
    private AuthService authService;

    @Autowired
    private ProgrammazioneService programmazioneService;


    // Endpoint per ottenere le programmazioni filtrate in base alle date
    // Se vengono passate credenziali valide (admin) restituisce tutto, altrimenti solo quelle in programmazione
    @GetMapping("/programmazioni")
    public List<Programmazione> getProgrammazioni(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInizio,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFine,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password) {


        if (username != null && password != null && authService.authenticate(username, password)) {
            return programmazioneService.getProgrammazioniByDate(dataInizio, dataFine);
        } else {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, -21);
            Date threeWeeksAgo = cal.getTime();
            if (dataInizio == null || dataInizio.before(threeWeeksAgo)) {
                dataInizio = threeWeeksAgo;
            }
            return programmazioneService.getProgrammazioniByDate(dataInizio, dataFine);
        }
    }
}


