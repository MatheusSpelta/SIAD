package com.example.SIAD.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SIAD.Dominio.Endereco;

@Repository
public interface EnderecoJPA extends JpaRepository<Endereco, Long> {

}
