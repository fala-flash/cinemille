package it.challenge.cinemille.api.entities;

import it.challenge.cinemille.api.models.Tecnologia;
import jakarta.persistence.*;

@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;
    private int capienza;
    @Enumerated(EnumType.STRING)
    private Tecnologia tecnologia;

    public Sala() {}

    public Sala(int numero, int capienza, Tecnologia tecnologia) {
        this.numero = numero;
        this.capienza = capienza;
        this.tecnologia = tecnologia;
    }


    public Long getId() {
        return id;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getCapienza() {
        return capienza;
    }
    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }
    public Tecnologia getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(Tecnologia tecnologia) {
        this.tecnologia = tecnologia;
    }
}

