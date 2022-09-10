package com.br.apibarbearia.resource;

import com.br.apibarbearia.model.DadosPessoais;
import com.br.apibarbearia.model.Funcionario;
import com.br.apibarbearia.model.ServicoOferecido;
import com.br.apibarbearia.service.ServicoOferecidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoOferecidoResource {

    @Autowired
    ServicoOferecidoService servicoOferecidoService;

    @PostMapping("/save")
    public ResponseEntity<ServicoOferecido> salvarServicoOferecido(@RequestBody ServicoOferecido servicoOferecido){
        return ResponseEntity.ok(servicoOferecidoService.adicionaServico(servicoOferecido));
    }

    @GetMapping("/find/all")
    public List<ServicoOferecido> allServicoOferecido() {
        return servicoOferecidoService.buscarTodosServicos();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ServicoOferecido> findById(@PathVariable Long id) {
        return ResponseEntity.ok(servicoOferecidoService.buscaPorId(id));
    }

    @PostMapping("/updade/{id}")
    public ResponseEntity<ServicoOferecido> alterarServicoOferecido(@PathVariable Long id , @RequestBody ServicoOferecido servicoOferecido){
        return ResponseEntity.ok(servicoOferecidoService.alterarServico(id ,servicoOferecido));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServicoOferecido> removerServicoOferecido(@PathVariable Long id){
        return ResponseEntity.ok(servicoOferecidoService.removeServicoPorId(id));
    }
}
