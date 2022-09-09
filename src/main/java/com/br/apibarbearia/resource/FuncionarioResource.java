package com.br.apibarbearia.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/add")
    public ResponseEntity<Funcionario> addDadoPessoal(@RequestBody Funcionario funcionario){
        return ResponseEntity.ok(funcionarioService.salvarDadosPessoais(funcionario));
    }
}
