package com.example.lancamentosservice.repository;

import com.example.lancamentosservice.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
