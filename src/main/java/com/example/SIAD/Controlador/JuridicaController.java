package com.example.SIAD.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.SIAD.Dominio.Juridica;
import com.example.SIAD.Servico.JuridicaService;

@RestController
@RequestMapping("/juridicas")
public class JuridicaController {

    @Autowired
    private JuridicaService juridicaService;

    @PostMapping
    public ResponseEntity<Object> cadastrarJuridica(@RequestBody Juridica juridica) {
        try {
            juridicaService.cadastrarJuridica(juridica);
            return ResponseEntity.ok("Pessoa juridica cadastrada com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro ao cadastrar Pessoa Juridica: " + e.getMessage());
        }
    }

    @GetMapping
    public List<Juridica> listarJuridica() {
        return juridicaService.listarJuridica();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarJuridica(@PathVariable Long id, @RequestBody Juridica juridica) {
        try {
            juridicaService.editarJuridica(id, juridica);
            return ResponseEntity.ok("Pessoa Juridica editada com sucesso");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro ao editar pessoa Juridica: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void excluirJuridica(@PathVariable Long id) {
        juridicaService.excluirJuridica(id);
    }
}