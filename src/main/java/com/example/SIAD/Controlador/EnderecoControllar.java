package com.example.SIAD.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SIAD.Dominio.Endereco;
import com.example.SIAD.Servico.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoControllar {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public Endereco cadastrarEndereco(@RequestBody Endereco endereco) {
        return enderecoService.cadastrarEndereco(endereco);
    }

    @GetMapping
    public List<Endereco> listarEndereco() {
        return enderecoService.listarEndereco();
    }

    @PutMapping("/{id}")
    public Endereco editarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        return enderecoService.editarEndereco(id, endereco);
    }

    @DeleteMapping("/{id}")
    public void deletarEndereco(@PathVariable Long id) {
        enderecoService.excluirEndereco(id);
    }

}
