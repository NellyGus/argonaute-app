package com.wildcodeschool.devtechchallenge.service;

import com.wildcodeschool.devtechchallenge.entity.Argonaute;
import com.wildcodeschool.devtechchallenge.repository.ArgonauteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * classe qui implemente le metier de la gestion des membre d'equipage
 *
 * @author Nelima BADJENE
 * @since 6/10/21
 */
@Service
@Transactional
public class ArgonauteService {
    private ArgonauteRepository argonauteRepository;

    public Argonaute create(Argonaute argonaute) {
        return argonauteRepository.save(argonaute);
    }

    @Transactional(readOnly = true)
    public List<Argonaute> getAll() {
        return argonauteRepository.findAll();
    }

    public ArgonauteRepository getRepository() {
        return argonauteRepository;
    }

    @Autowired
    public void setMembreRepository(ArgonauteRepository argonauteRepository) {
        this.argonauteRepository = argonauteRepository;
    }
}
