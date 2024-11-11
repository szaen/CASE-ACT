package com.example.lancamentosservice.controller;

import com.example.lancamentosservice.Lancamento;
import com.example.lancamentosservice.service.LancamentoService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lancamentos")
public class LancamentoController {

    private final LancamentoService lancamentoService;

    public LancamentoController(LancamentoService lancamentoService) {
        this.lancamentoService = lancamentoService;
    }

    @GetMapping
    public ResponseEntity<List<Lancamento>> getAllLancamentos() {
        List<Lancamento> lancamentos = lancamentoService.findAll();
        return new ResponseEntity<>(lancamentos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> getLancamentoById(@PathVariable Long id) {
        Optional<Lancamento> lancamento = lancamentoService.findById(id);
        return lancamento.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Lancamento> createLancamento(@RequestBody Lancamento lancamento) {
        Lancamento createdLancamento = lancamentoService.save(lancamento);
        return new ResponseEntity<>(createdLancamento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lancamento> updateLancamento(@PathVariable Long id, @RequestBody Lancamento lancamento) {
        Optional<Lancamento> existingLancamento = lancamentoService.findById(id);
        if (existingLancamento.isPresent()) {
            lancamento.setId(id);
            Lancamento updatedLancamento = lancamentoService.save(lancamento);
            return new ResponseEntity<>(updatedLancamento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

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