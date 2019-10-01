package com.raulzito.algamoneyapi.repository.lancamento;

import com.raulzito.algamoneyapi.model.Lancamento;
import com.raulzito.algamoneyapi.repository.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoRepositoryQuery {

    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);

}
