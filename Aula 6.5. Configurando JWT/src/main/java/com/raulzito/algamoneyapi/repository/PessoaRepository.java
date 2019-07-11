package com.raulzito.algamoneyapi.repository;

import com.raulzito.algamoneyapi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
