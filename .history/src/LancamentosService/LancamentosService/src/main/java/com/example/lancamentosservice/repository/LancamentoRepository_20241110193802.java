package com.example.lancamentosservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lancamentosservice.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}