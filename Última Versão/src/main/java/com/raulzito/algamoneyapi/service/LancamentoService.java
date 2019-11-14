package com.raulzito.algamoneyapi.service;

import com.raulzito.algamoneyapi.model.Categoria;
import com.raulzito.algamoneyapi.model.Lancamento;
import com.raulzito.algamoneyapi.model.Pessoa;
import com.raulzito.algamoneyapi.repository.CategoriaRepository;
import com.raulzito.algamoneyapi.repository.LancamentoRepository;
import com.raulzito.algamoneyapi.repository.PessoaRepository;
import com.raulzito.algamoneyapi.service.exception.ObjetoInexistenteException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Lancamento salvar(Lancamento lancamento) {
        verificaPessoa(lancamento);
        verificaCategoria(lancamento);
        return lancamentoRepository.save(lancamento);
    }

    public Lancamento atualizar(Long codigo, Lancamento lancamento) {
        Optional<Lancamento> lancamentoAntigo = lancamentoRepository.findById(codigo);
        if (!lancamentoAntigo.isPresent()) {
            throw new ObjetoInexistenteException("Lancamento");
        }
        verificaPessoa(lancamento);
        verificaCategoria(lancamento);
        lancamento.setCodigo(codigo);

        return lancamentoRepository.save(lancamento);
    }

    public void verificaPessoa(Lancamento lancamento) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
        if (!pessoa.isPresent() || pessoa.get().isInativo()) {
            throw new ObjetoInexistenteException("Pessoa");
        }
    }

    private void verificaCategoria(Lancamento lancamento) {
        Optional<Categoria> categoria = categoriaRepository.findById(lancamento.getCategoria().getCodigo());
        if (!categoria.isPresent()) {
            throw new ObjetoInexistenteException("Categoria");
        }
    }
}
