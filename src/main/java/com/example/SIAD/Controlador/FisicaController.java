package com.example.SIAD.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SIAD.Dominio.Endereco;
import com.example.SIAD.Dominio.Fisica;
import com.example.SIAD.Repositorio.EnderecoJPA;
import com.example.SIAD.Repositorio.FisicaJPA;
import com.example.SIAD.Servico.FisicaService;

@RestController
@RequestMapping("/fisicas")
public class FisicaController {

    @Autowired
    public FisicaController(FisicaJPA fisicaJPA, EnderecoJPA enderecoJPA) {
        this.fisicaJPA = fisicaJPA;
        this.enderecoJPA = enderecoJPA;
    }

    @Autowired
    private FisicaService fisicaService;

    private final FisicaJPA fisicaJPA;
    private final EnderecoJPA enderecoJPA;

    @PostMapping
    public ResponseEntity<Fisica> cadastrarFisica(@RequestBody Fisica fisica) {
        Endereco endereco = fisica.getEndereco();
        if (endereco != null) {
            endereco = enderecoJPA.save(endereco);
            fisica.setEndereco(endereco);
        }
        fisicaJPA.save(fisica);
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
