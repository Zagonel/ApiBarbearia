package com.br.apibarbearia.service;

import com.br.apibarbearia.model.DadosPessoais;
import com.br.apibarbearia.repository.DadosPessoaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DadosPessoaisService {

    @Autowired
    private DadosPessoaisRepository dadosPessoaisRepository;

    public DadosPessoais salvarDadosPessoais(DadosPessoais dadosPessoais) {
        return dadosPessoaisRepository.save(dadosPessoais);
    }
}
