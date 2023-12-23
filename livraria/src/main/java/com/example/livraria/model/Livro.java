package com.example.livraria.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "livros")
public class Livro {
    @Id()
    @Column(name = "LVR_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 100,nullable = false,name = "LVR_titulo")
    private String titulo;

    @Column(name = "LVR_data_lancamento")
    private Date lancamento;

    @OneToMany()
    @JoinColumn(name = "LVR_autores", nullable = false)
    private List<Autor> autores;

    @Column(name = "LVR_edicao")
    private String edicao;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "LVR_genero", nullable = false)
    private Genero genero;

    @Column(name = "LVR_preco")
    private double preco;
}
