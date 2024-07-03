package com.example.SIAD.Servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SIAD.Dominio.Juridica;
import com.example.SIAD.Repositorio.JuridicaJPA;

@Service
public class JuridicaService {
    @Autowired
    private JuridicaJPA juridicaJPA;

    public Juridica cadastrarJuridica(Juridica juridica) {
        return juridicaJPA.save(juridica);
    }

    public List<Juridica> listarJuridica() {
        return juridicaJPA.findAll();
    }

    public Optional<Juridica> encontrarJuridicaPorId(Long id) {
        return juridicaJPA.findById(id);
    }

    public Juridica editarJuridica(Long id, Juridica juridica) {
        juridica.setId(id);
        return juridicaJPA.save(juridica);
    }

    public void excluirJuridica(Long id) {
        juridicaJPA.deleteById(id);
    }

}
