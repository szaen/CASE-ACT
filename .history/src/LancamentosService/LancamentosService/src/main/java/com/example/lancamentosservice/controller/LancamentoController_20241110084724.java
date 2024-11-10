package com.example.lancamentosservice.controller;

import com.example.lancamentosservice.Lancamento;
import com.example.lancamentosservice.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lancamentos")
public class LancamentoController {

    private final LancamentoService lancamentoService;

    @Autowired
    public LancamentoController(LancamentoService lancamentoService) {
        this.lancamentoService = lancamentoService;
    }

    // Endpoint para buscar todos os lançamentos
    @GetMapping
    public ResponseEntity<List<Lancamento>> getAllLancamentos() {
        List<Lancamento> lancamentos = lancamentoService.findAll();
        return new ResponseEntity<>(lancamentos, HttpStatus.OK);
    }

    // Endpoint para buscar um lançamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> getLancamentoById(@PathVariable Long id) {
        Optional<Lancamento> lancamento = lancamentoService.findById(id);
        return lancamento.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para criar um novo lançamento
    @PostMapping
    public ResponseEntity<Lancamento> createLancamento(@RequestBody Lancamento lancamento) {
        Lancamento createdLancamento = lancamentoService.save(lancamento);
        return new ResponseEntity<>(createdLancamento, HttpStatus.CREATED);
    }

    // Endpoint para atualizar um lançamento existente
    @PutMapping("/{id}")
    public ResponseEntity<Lancamento> updateLancamento(@PathVariable Long id, @RequestBody Lancamento lancamento) {
        Optional<Lancamento> existingLancamento = lancamentoService.findById(id);
        if (existingLancamento.isPresent()) {
            lancamento.setId(id); // Define o ID para garantir que o lançamento seja atualizado
            Lancamento updatedLancamento = lancamentoService.save(lancamento);
            return new ResponseEntity<>(updatedLancamento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para deletar um lançamento por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLancamento(@PathVariable Long id) {
        if (lancamentoService.findById(id).isPresent()) {
            lancamentoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
