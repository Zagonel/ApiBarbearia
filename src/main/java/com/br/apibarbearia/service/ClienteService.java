package com.br.apibarbearia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.apibarbearia.model.Cliente;
import com.br.apibarbearia.model.DadosPessoais;
import com.br.apibarbearia.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private DadosPessoaisService dadosPessoaisService;
	
	public Cliente salvarCliente(Cliente cliente) {
    	
    	DadosPessoais dadosPessoais = dadosPessoaisService.buscarDadosPessoaisById(cliente.getDadosPessoais().getId());

    	if(dadosPessoais == null ) {
    		throw new RuntimeException();
    	}
    	cliente.setDadosPessoais(dadosPessoais);
        return clienteRepository.save(cliente);
    }
	
	public Cliente buscarCliente(Long id) {
    	return clienteRepository.findById(id).get();
    }
    
    public List<Cliente> buscarTodosClientes() {
    	return clienteRepository.findAll();
    }
    
    public Cliente alterarCliente(Long id,Cliente cliente) {
    	
    	Optional<Cliente> funcionarioSalvo = clienteRepository.findById(id);

    	if(funcionarioSalvo == null ) {
    		throw new RuntimeException();
    	}  	
    	BeanUtils.copyProperties(cliente, funcionarioSalvo.get(),"id");
        return clienteRepository.save(funcionarioSalvo.get());
    }
    
    public Cliente removerCliente(Long id) {
    	
    	Optional<Cliente> funcionarioSalvo = clienteRepository.findById(id);

    	if(funcionarioSalvo == null ) {
    		throw new RuntimeException();
    	}
    	clienteRepository.deleteById(id);
    	return null;
    }
}
