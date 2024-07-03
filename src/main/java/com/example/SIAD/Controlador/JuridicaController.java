package com.example.SIAD.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.SIAD.Dominio.Juridica;
import com.example.SIAD.Servico.JuridicaService;

@RestController
@RequestMapping("/juridicas")
public class JuridicaController {

    @Autowired
    private JuridicaService juridicaService;

    @PostMapping
    public Juridica cadastrarJuridica(@RequestBody Juridica juridica) {
        return juridicaService.cadastrarJuridica(juridica);
    }

    @GetMapping
    public List<Juridica> listarJuridica() {
        return juridicaService.listarJuridica();
    }

    @PutMapping("/{id}")
    public Juridica atualizarJuridica(@PathVariable Long id, @RequestBody Juridica juridica) {
        return juridicaService.editarJuridica(id, juridica);
    }

    @DeleteMapping("/{id}")
    public void excluirJuridica(@PathVariable Long id) {
        juridicaService.excluirJuridica(id);
    }
}