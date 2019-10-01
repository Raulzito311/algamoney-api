package com.raulzito.algamoneyapi.repository;

import com.raulzito.algamoneyapi.model.Lancamento;
import com.raulzito.algamoneyapi.repository.lancamento.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {
}
