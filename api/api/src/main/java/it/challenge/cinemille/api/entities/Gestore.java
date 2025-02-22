package it.challenge.cinemille.api.entities;


import jakarta.persistence.*;

@Entity
public class Gestore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    public Gestore() {}

    public Gestore(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

