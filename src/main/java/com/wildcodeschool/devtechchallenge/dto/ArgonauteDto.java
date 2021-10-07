package com.wildcodeschool.devtechchallenge.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * dto qui encapsule les informations d'un membre d'equipage
 *
 * @author Nelima BADJENE
 * @since 6/10/21
 */
@Getter
@Setter
public class ArgonauteDto {

    private Long id;

    @NotBlank(message = "membre.nom.notBlank")
    private String nom;
}
