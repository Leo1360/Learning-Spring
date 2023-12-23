package com.example.livraria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.livraria.model.Livro;
import com.example.livraria.repositories.LivroRespository;
import com.example.livraria.services.LivroService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService service;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Livro>> listAll(){
        return new ResponseEntity<>(service.listAll(),HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/name/{nome}")
    public ResponseEntity<List<Livro>> findByName(@PathVariable String nome){
        return new ResponseEntity<>(service.findByName(nome), HttpStatus.OK);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Void> save(@RequestBody Livro livro){
        service.save(livro);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK); 
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Void> update(@RequestBody Livro livro){
        service.update(livro);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
