package com.br.apibarbearia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.apibarbearia.model.Funcionario;
import com.br.apibarbearia.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario salvarDadosPessoais(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }
}
