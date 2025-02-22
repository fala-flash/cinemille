package it.challenge.cinemille.api.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titolo;

    @Temporal(TemporalType.DATE)
    private Date dataUscita;

    private int durata; // in minuti

    public Film() {}

    public Film(String titolo, Date dataUscita, int durata) {
        this.titolo = titolo;
        this.dataUscita = dataUscita;
        this.durata = durata;
    }

    public Long getId() {
        return id;
    }
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public Date getDataUscita() {
        return dataUscita;
    }
    public void setDataUscita(Date dataUscita) {
        this.dataUscita = dataUscita;
    }
    public int getDurata() {
        return durata;
    }
    public void setDurata(int durata) {
        this.durata = durata;
    }
}

