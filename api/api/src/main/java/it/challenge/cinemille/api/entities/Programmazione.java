package it.challenge.cinemille.api.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Programmazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dataInizio;

    @Temporal(TemporalType.DATE)
    private Date dataFine;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    public Programmazione() {}

    public Programmazione(Date dataInizio, Date dataFine, Film film, Sala sala) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.film = film;
        this.sala = sala;
    }


    public Long getId() {
        return id;
    }
    public Date getDataInizio() {
        return dataInizio;
    }
    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }
    public Date getDataFine() {
        return dataFine;
    }
    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }
    public Film getFilm() {
        return film;
    }
    public void setFilm(Film film) {
        this.film = film;
    }
    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
