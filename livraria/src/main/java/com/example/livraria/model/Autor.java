package com.example.livraria.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "autores")
public class Autor {
    @Id
    @Column(name = "AUT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "AUT_nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "AUT_descricao",length = 500)
    private String descricao;

    @Column(name = "AUT_nascimento")
    private Date nascimento;
}