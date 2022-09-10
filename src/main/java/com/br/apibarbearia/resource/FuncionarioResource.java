package com.br.apibarbearia.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.apibarbearia.model.Funcionario;
import com.br.apibarbearia.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioResource {

	@Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/save")
    public ResponseEntity<Funcionario> salvarFuncionario(@RequestBody Funcionario funcionario){
        return ResponseEntity.ok(funcionarioService.salvarFuncionario(funcionario));
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Funcionario> buscarFuncionario(Long id){
        return ResponseEntity.ok(funcionarioService.buscarFuncionario(id));
    }
    
    @PostMapping("/updade/{id}")
    public ResponseEntity<Funcionario> alterarFuncionario(@PathVariable Long id ,@RequestBody Funcionario funcionario){
        return ResponseEntity.ok(funcionarioService.alterarFuncionario(id ,funcionario));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Funcionario> removerFuncionario(@PathVariable Long id){
        return ResponseEntity.ok(funcionarioService.removerFuncionario(id));
    }
}
