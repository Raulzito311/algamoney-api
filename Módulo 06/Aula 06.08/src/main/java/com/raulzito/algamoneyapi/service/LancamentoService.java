package com.raulzito.algamoneyapi.service;

import com.raulzito.algamoneyapi.model.Lancamento;
import com.raulzito.algamoneyapi.model.Pessoa;
import com.raulzito.algamoneyapi.repository.LancamentoRepository;
import com.raulzito.algamoneyapi.repository.PessoaRepository;
import com.raulzito.algamoneyapi.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
        if (!pessoa.isPresent() || pessoa.get().isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }
        return lancamentoRepository.save(lancamento);
    }

}
