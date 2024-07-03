package com.example.SIAD.Controlador;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SIAD.Dominio.Venda;
import com.example.SIAD.Servico.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<Object> cadastrarVenda(@RequestBody Venda venda) {
        try {
            vendaService.calcularValor(venda);
            System.out.println(venda.getQuantidade());
            System.out.println(venda.getProduto().getValor());
            vendaService.cadastrarVenda(venda);
            return ResponseEntity.ok("Venda cadastrada com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro ao cadastrar venda: " + e.getMessage());
        }
    }

    @GetMapping
    public List<Venda> listarVendas() {
        return vendaService.listarVenda();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editarVenda(@PathVariable Long id, @RequestBody Venda venda) {
        vendaService.editarVenda(id, venda);
        return ResponseEntity.ok("Venda atualizada com sucesso");
    }

    @DeleteMapping("/{id}")
    public void deletarVenda(@PathVariable Long id) {
        vendaService.excluirVenda(id);
    }

}
