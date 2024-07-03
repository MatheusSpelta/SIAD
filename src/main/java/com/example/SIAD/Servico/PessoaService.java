package com.example.SIAD.Servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SIAD.Dominio.Pessoa;
import com.example.SIAD.Repositorio.PessoaJPA;

@Service
public class PessoaService {
    @Autowired
    private PessoaJPA pessoaJPA;

    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        return pessoaJPA.save(pessoa);
    }

    public List<Pessoa> listarPessoa() {
        return pessoaJPA.findAll();
    }

    public Optional<Pessoa> encontrarPessoaPorId(Long id) {
        return pessoaJPA.findById(id);
    }

    public Pessoa editarPessoa(Long id, Pessoa pessoa) {
        pessoa.setId(id);
        return pessoaJPA.save(pessoa);
    }

    public void excluirPessoa(Long id) {
        pessoaJPA.deleteById(id);
    }
}
