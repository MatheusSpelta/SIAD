package com.example.SIAD.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.SIAD.Dominio.Pessoa;
import com.example.SIAD.Servico.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Object> cadastrarPessoa(@RequestBody Pessoa pessoa) {
        try {
            pessoaService.cadastrarPessoa(pessoa);
            return ResponseEntity.ok("Pessoa Cadastrada com sucesso");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro ao cadastrar pessoa: " + e.getMessage());
        }
    }

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaService.listarPessoa();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        try {
            pessoaService.editarPessoa(id, pessoa);
            return ResponseEntity.ok("Pessoa cadastrada com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro ao editar pessoa: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletarPessoa(@PathVariable Long id) {
        pessoaService.excluirPessoa(id);
    }
}
