package com.example.SIAD.Servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SIAD.Dominio.Produto;
import com.example.SIAD.Dominio.Venda;
import com.example.SIAD.Repositorio.VendaJPA;

@Service
public class VendaService {
    @Autowired
    private VendaJPA vendaJPA;

    public Venda cadastrarVenda(Venda venda) {
        return vendaJPA.save(venda);
    }

    public List<Venda> listarVenda() {
        return vendaJPA.findAll();
    }

    public Optional<Venda> encontrarVendaPorId(Long id) {
        return vendaJPA.findById(id);
    }

    public Venda editarVenda(Long id, Venda venda) {
        venda.setId(id);
        return vendaJPA.save(venda);
    }

    public void excluirVenda(Long id) {
        vendaJPA.deleteById(id);
    }

    public void calcularValor(Venda venda) {
        Produto produto = venda.getProduto();
        if (produto != null && produto.getValor() != null) {
            Double valorTotal = produto.getValor() * venda.getQuantidade();
            venda.setTotal(valorTotal);
        } else {
            throw new IllegalArgumentException("Produto ou valor do produto não podem ser nulos");
        }

    }
}
