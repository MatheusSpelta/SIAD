package com.example.SIAD.Servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SIAD.Dominio.Endereco;
import com.example.SIAD.Repositorio.EnderecoJPA;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoJPA enderecoJPA;

    public Endereco cadastrarEndereco(Endereco endereco) {
        return enderecoJPA.save(endereco);
    }

    public List<Endereco> listarEndereco() {
        return enderecoJPA.findAll();
    }

    public Optional<Endereco> encontrarEnderecoPorId(Long id) {
        return enderecoJPA.findById(id);
    }

    public Endereco editarEndereco(Long id, Endereco endereco){
        endereco.setId(id);
        return enderecoJPA.save(endereco);
    }

    public void excluirEndereco(Long id){
        enderecoJPA.deleteById(id);
    }
}
