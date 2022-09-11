package com.br.apibarbearia.resource;

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

    @PostMapping("/save/{id}/{valor}")
    public ResponseEntity<ServicoRealizado> salvarServicoRealizado(@RequestParam Long id, @RequestParam Long valor){
        return ResponseEntity.ok(servicoRealizadoService.salvarServicoRealizado(id, valor));
    }
}
