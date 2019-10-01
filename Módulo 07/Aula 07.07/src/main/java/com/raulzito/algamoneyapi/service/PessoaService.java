package com.raulzito.algamoneyapi.service;

import com.raulzito.algamoneyapi.model.Pessoa;
import com.raulzito.algamoneyapi.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa atualizar(Long codigo, Pessoa pessoa) {

        Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);

        BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");

        return pessoaRepository.save(pessoaSalva);
    }

    public void atualizaPropiedadeAtivo(Long codigo, Boolean ativo) {
        Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
        pessoaSalva.setAtivo(ativo);
        pessoaRepository.save(pessoaSalva);
    }

    public Pessoa buscarPessoaPeloCodigo(Long codigo) {
        return pessoaRepository.findById(codigo)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }
}
