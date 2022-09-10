package com.br.apibarbearia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.apibarbearia.model.DadosPessoais;
import com.br.apibarbearia.model.Funcionario;
import com.br.apibarbearia.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
    private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private DadosPessoaisService dadosPessoaisService;

    public Funcionario salvarFuncionario(Funcionario funcionario) {
    	
    	DadosPessoais dadosPessoais = dadosPessoaisService.buscarDadosPessoaisById(funcionario.getDadosPessoais().getId());
    	
    	if(dadosPessoais == null ) {
    		throw new RuntimeException();
    	}
    	
    	funcionario.setDadosPessoais(dadosPessoais);;
    	
        return funcionarioRepository.save(funcionario);
    }
}
