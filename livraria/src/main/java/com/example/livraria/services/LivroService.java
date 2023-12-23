package com.example.livraria.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ResponseStatusException;

import com.example.livraria.model.Livro;
import com.example.livraria.repositories.LivroRespository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRespository repo;

    public List<Livro> listAll() {
        return repo.findAll();
    }

    public List<Livro> findByName(String nome){
        return repo.findByNome(nome);
    }

    public Livro findById(Long id){
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Livro não encontrado"));
    }

    public void save(Livro livro){
        repo.save(livro);
    }

    public void delete(Long id){
        repo.delete(findById(id));
    }

    public void update(Livro livro){
        findById(livro.getId());
        repo.save(livro);
    }

}
