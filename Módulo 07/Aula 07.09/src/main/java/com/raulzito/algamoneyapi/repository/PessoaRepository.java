package com.raulzito.algamoneyapi.repository;

import com.raulzito.algamoneyapi.model.Pessoa;
import com.raulzito.algamoneyapi.repository.filter.PessoaFilter;
import com.raulzito.algamoneyapi.repository.pessoa.PessoaRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaRepositoryQuery {
}
