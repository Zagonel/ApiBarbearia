package com.br.apibarbearia.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
    	funcionario.setDadosPessoais(dadosPessoais);
        return funcionarioRepository.save(funcionario);
    }
    
    public Funcionario buscarFuncionario(Long id) {
    	return funcionarioRepository.findById(id).get();
    }
    
    public Funcionario alterarFuncionario(Long id,Funcionario funcionario) {
    	
    	Optional<Funcionario> funcionarioSalvo = funcionarioRepository.findById(id);

    	if(funcionarioSalvo == null ) {
    		throw new RuntimeException();
    	}  	
    	BeanUtils.copyProperties(funcionario, funcionarioSalvo.get());
        return funcionarioRepository.save(funcionarioSalvo.get());
    }
    
    public Funcionario removerFuncionario(Long id) {
    	
    	Optional<Funcionario> funcionarioSalvo = funcionarioRepository.findById(id);

    	if(funcionarioSalvo == null ) {
    		throw new RuntimeException();
    	}
    	funcionarioRepository.deleteById(id);
    	return null;
    }
}
