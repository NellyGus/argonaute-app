package com.wildcodeschool.devtechchallenge.controller;

import com.wildcodeschool.devtechchallenge.dto.ArgonauteDto;
import com.wildcodeschool.devtechchallenge.entity.Argonaute;
import com.wildcodeschool.devtechchallenge.service.ArgonauteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * controller qui expose les endpoints de gestion de membres d'equipage
 *
 * @author Nelima BADJENE
 * @since 6/10/21
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/argonautes")
public class ArgonauteController {
    private ArgonauteService argonauteService;

    @PostMapping
    public ResponseEntity<Argonaute> create(@Valid @RequestBody ArgonauteDto argonauteDto) {
        final Argonaute argonaute = Argonaute.of(argonauteDto);
        return new ResponseEntity<>(argonauteService.create(argonaute), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Argonaute>> findAll() {
        return new ResponseEntity<>(argonauteService.getAll(), HttpStatus.OK);
    }

    @Autowired
    public void setMembreService(ArgonauteService argonauteService) {
        this.argonauteService = argonauteService;
    }
}
