package it.challenge.cinemille.api.services;

import it.challenge.cinemille.api.entities.Gestore;
import it.challenge.cinemille.api.repositories.GestoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private GestoreRepository gestoreRepository;

    public boolean authenticate(String username, String password) {
        Gestore gestore = gestoreRepository.findByUsername(username);
        return gestore != null && gestore.getPassword().equals(password);
    }
}

