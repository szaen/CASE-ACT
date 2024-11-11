package com.example.lancamentosservice.service;

import com.example.lancamentosservice.Lancamento;
import com.example.lancamentosservice.repository.LancamentoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {

    private final LancamentoRepository lancamentoRepository;

    public LancamentoService(LancamentoRepository lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    public List<Lancamento> findAll() {
        return lancamentoRepository.findAll();
    }

    public Optional<Lancamento> findById(Long id) {
        return lancamentoRepository.findById(id);
    }

    public Lancamento save(Lancamento lancamento) {
        return lancamentoRepository.save(lancamento);
    }

    public void deleteById(Long id) {
        lancamentoRepository.deleteById(id);
    }
}