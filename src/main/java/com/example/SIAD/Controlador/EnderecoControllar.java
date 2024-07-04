package com.example.SIAD.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.SIAD.Dominio.Endereco;
import com.example.SIAD.Servico.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoControllar {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Object> cadastrarEndereco(@RequestBody Endereco endereco) {
        try {
            enderecoService.cadastrarEndereco(endereco);
            return ResponseEntity.ok("Endereço cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro ao cadastrar endereço: " + e.getMessage());
        }
    }

    @GetMapping
    public List<Endereco> listarEndereco() {
        return enderecoService.listarEndereco();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        try {
            enderecoService.editarEndereco(id, endereco);
            return ResponseEntity.ok("Endereço editado com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro ao editar endereço: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletarEndereco(@PathVariable Long id) {
        enderecoService.excluirEndereco(id);
    }

}
