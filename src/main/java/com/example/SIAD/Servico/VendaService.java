package com.example.SIAD.Servico;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SIAD.Dominio.Produto;
import com.example.SIAD.Dominio.Venda;
import com.example.SIAD.Dominio.DTO.VendaDTO;
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

    @Transactional(readOnly = true)
    public List<VendaDTO> listarVendasFormatado() {

        return vendaJPA.findAll().stream().map(venda -> new VendaDTO(venda.getId(), venda.getTotal(),
                venda.getQuantidade(), venda.getFisica().getId(), venda.getFisica().getNome(),
                venda.getProduto().getId(), venda.getProduto().getNome(), venda.getProduto().getValor()))
                .collect(Collectors.toList());
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
