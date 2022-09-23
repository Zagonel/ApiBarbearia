package com.br.apibarbearia.resource;

import com.br.apibarbearia.dto.ServicoRealizadoDto;
import com.br.apibarbearia.model.ServicoRealizado;
import com.br.apibarbearia.service.ServicoRealizadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servico-realizado")
public class ServicoRealizadoResource {

    @Autowired
    ServicoRealizadoService servicoRealizadoService;

    @PostMapping("/save/{id}")
    public ResponseEntity<ServicoRealizado> salvarServicoRealizado(@PathVariable Long id, @RequestBody ServicoRealizadoDto servicoRealizadoDto){
        return ResponseEntity.ok(servicoRealizadoService.salvarServicoRealizado(id, servicoRealizadoDto));
    }

    @GetMapping("/find")
    public List<ServicoRealizado> buscarServicoRealizadoByCliente(@RequestParam String cpf, @RequestParam int id){
        return servicoRealizadoService.buscarServicoRealizadoByCliente(cpf , id);
    }
}
