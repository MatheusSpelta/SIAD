package com.example.SIAD.Servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SIAD.Dominio.Fisica;
import com.example.SIAD.Repositorio.FisicaJPA;

@Service
public class FisicaService {
    @Autowired
    private FisicaJPA fisicaJPA;

    public Fisica cadastrarFisica(Fisica fisica) {
        return fisicaJPA.save(fisica);
    }

    public List<Fisica> listarFisica(){
        return fisicaJPA.findAll();
    }

    public Optional<Fisica> encontrarFisicaPorId(long id){
        return fisicaJPA.findById(id);
    }

    public Fisica editarFisica(Long id, Fisica fisica){
        fisica.setId(id);
        return fisicaJPA.save(fisica);
    }

    public void excluirFisica(Long id){
        fisicaJPA.deleteById(id);
    }
}
