package com.example.SIAD.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SIAD.Dominio.Produto;

@Repository
public interface ProdutoJPA extends JpaRepository<Produto, Long>{
    
}
