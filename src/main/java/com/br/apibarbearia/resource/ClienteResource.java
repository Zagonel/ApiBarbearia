package com.br.apibarbearia.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.apibarbearia.model.Cliente;
import com.br.apibarbearia.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/save")
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.salvarCliente(cliente));
    }
	
	@GetMapping("/find/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarCliente(id));
    }
    
    @GetMapping("/find/all")
    public ResponseEntity<List<Cliente>> buscarTodosClientes(){
    	return ResponseEntity.ok(clienteService.buscarTodosClientes());
    }
    
    @PostMapping("/updade/{id}")
    public ResponseEntity<Cliente> alterarCliente(@PathVariable Long id ,@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.alterarCliente(id ,cliente));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Cliente> removerCliente(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.removerCliente(id));
    }
}
