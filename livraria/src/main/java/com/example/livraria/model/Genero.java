package com.example.livraria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "generos")
public class Genero {
    @Id
    @Column(name = "GNR_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "GNR_nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "GNR_descicao",length = 500)
    private String descricao;
}
