package com.example.livraria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.livraria.model.Livro;

public interface LivroRespository extends JpaRepository<Livro,Long>{
    List<Livro> findByNome(String nome);
}
