package com.example.SIAD.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SIAD.Dominio.Pessoa;

@Repository
public interface PessoaJPA extends JpaRepository<Pessoa, Long> {

}
