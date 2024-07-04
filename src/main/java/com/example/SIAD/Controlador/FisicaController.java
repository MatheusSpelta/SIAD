package com.example.SIAD.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.SIAD.Dominio.Fisica;
import com.example.SIAD.Servico.FisicaService;

@RestController
@RequestMapping("/fisicas")
public class FisicaController {

    @Autowired
    private FisicaService fisicaService;

    @PostMapping
    public ResponseEntity<Object> cadastrarFisica(@RequestBody Fisica fisica) {
        try {
            fisicaService.cadastrarFisica(fisica);
            ResponseEntity.ok("Pessoa fisica cadastrada");
        } catch (Exception e) {
            ResponseEntity.badRequest().body("Erro ao cadastrar pessoa fisica" + e.getMessage());
        }
        return new ResponseEntity<>(fisica, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Fisica> listarFisica() {
        return fisicaService.listarFisica();
    }

    @PutMapping("/{id}")
    public Fisica editarFisica(@PathVariable Long id, @RequestBody Fisica fisica) {
        return fisicaService.editarFisica(id, fisica);
    }

    @DeleteMapping("/{id}")
    public void deletarFisica(@PathVariable Long id) {
        fisicaService.excluirFisica(id);
    }
}
