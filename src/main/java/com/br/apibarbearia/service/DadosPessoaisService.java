package com.br.apibarbearia.service;

import com.br.apibarbearia.model.DadosPessoais;
import com.br.apibarbearia.repository.DadosPessoaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DadosPessoaisService {

    @Autowired
    private DadosPessoaisRepository dadosPessoaisRepository;

    public DadosPessoais salvarDadosPessoais(DadosPessoais dadosPessoais) {
        return dadosPessoaisRepository.save(dadosPessoais);
    }

    public DadosPessoais buscarDadosPessoaisById(Long Id){
        Optional<DadosPessoais> cliente =  dadosPessoaisRepository.findById(Id);
        return cliente.get();
    }
}
