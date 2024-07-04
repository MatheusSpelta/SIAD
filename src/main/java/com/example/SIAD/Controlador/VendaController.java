package com.example.SIAD.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.SIAD.Dominio.Venda;
import com.example.SIAD.Dominio.DTO.VendaDTO;
import com.example.SIAD.Servico.ProdutoService;
import com.example.SIAD.Servico.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Object> cadastrarVenda(@RequestBody Venda venda) {
        try {
            venda.setProduto(produtoService.definirProdutoPorID(venda.getProduto().getId()));
            vendaService.calcularValor(venda);
            vendaService.cadastrarVenda(venda);
            return ResponseEntity.ok("Venda cadastrada com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro ao cadastrar venda: " + e.getMessage());
        }
    }

    /*
     * @GetMapping
     * public List<Venda> listarVendas() {
     * return vendaService.listarVenda();
     * }
     */

    @GetMapping
    public ResponseEntity<List<VendaDTO>> listarVendasFormatadas() {
        List<VendaDTO> vendas = vendaService.listarVendasFormatado();
        return ResponseEntity.ok(vendas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editarVenda(@PathVariable Long id, @RequestBody Venda venda) {
        try {
            venda.setProduto(produtoService.definirProdutoPorID(venda.getProduto().getId()));
            vendaService.calcularValor(venda);
            vendaService.editarVenda(id, venda);
            return ResponseEntity.ok("Venda atualizada com sucesso");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro ao editar venda: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletarVenda(@PathVariable Long id) {
        vendaService.excluirVenda(id);
    }

}
