package com.wildcodeschool.devtechchallenge.entity;

import com.wildcodeschool.devtechchallenge.dto.ArgonauteDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * classe qui stocke les informations d'un membre d'equipage
 *
 * @author Nelima BADJENE
 * @since 6/10/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Argonaute implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    public static Argonaute of (ArgonauteDto dto) {
        Argonaute argonaute = new Argonaute();
        argonaute.setId(dto.getId());
        argonaute.setNom(dto.getNom());
        return argonaute;
    }
}
