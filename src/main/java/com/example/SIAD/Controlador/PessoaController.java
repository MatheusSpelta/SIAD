package com.example.SIAD.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.SIAD.Dominio.Pessoa;
import com.example.SIAD.Servico.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.cadastrarPessoa(pessoa);
    }

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaService.listarPessoa();
    }

    @PutMapping("/{id}")
    public Pessoa editarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        return pessoaService.editarPessoa(id, pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletarPessoa(@PathVariable Long id) {
        pessoaService.excluirPessoa(id);
    }
}
