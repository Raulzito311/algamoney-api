package com.raulzito.algamoneyapi.repository.pessoa;

import com.raulzito.algamoneyapi.model.Pessoa;
import com.raulzito.algamoneyapi.repository.filter.PessoaFilter;

import java.util.List;

public interface PessoaRepositoryQuery {

    public List<Pessoa> filtrar(PessoaFilter pessoaFilter);

}
