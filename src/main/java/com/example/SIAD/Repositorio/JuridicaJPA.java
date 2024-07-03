package com.example.SIAD.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SIAD.Dominio.Juridica;

@Repository
public interface JuridicaJPA extends JpaRepository<Juridica, Long> {

}
