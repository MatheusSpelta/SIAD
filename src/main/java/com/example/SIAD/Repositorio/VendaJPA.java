package com.example.SIAD.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SIAD.Dominio.Venda;

@Repository
public interface VendaJPA extends JpaRepository<Venda, Long> {

}
