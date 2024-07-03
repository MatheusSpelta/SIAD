package com.example.SIAD.Servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SIAD.Dominio.Produto;
import com.example.SIAD.Repositorio.ProdutoJPA;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoJPA produtoJPA;

    public Produto cadastrarProduto(Produto produto) {
        return produtoJPA.save(produto);
    }

    public List<Produto> listarProduto() {
        return produtoJPA.findAll();
    }

    public Optional<Produto> encontrarPessoaPorId(Long id) {
        return produtoJPA.findById(id);
    }

    public Produto editarProduto(Long id, Produto produto) {
        produto.setId(id);
        return produtoJPA.save(produto);
    }

    public void excluirProduto(Long id) {
        produtoJPA.deleteById(id);
    }

}
