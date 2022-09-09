package com.br.apibarbearia.resource;

import com.br.apibarbearia.model.DadosPessoais;
import com.br.apibarbearia.service.DadosPessoaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dadopessoal")
public class DadosPessoaisResource {

    @Autowired
    private DadosPessoaisService dadosPessoaisService;

    @PostMapping("/add")
    public ResponseEntity<DadosPessoais> addDadoPessoal(@RequestBody DadosPessoais dadosPessoais){
        return ResponseEntity.ok(dadosPessoaisService.salvarDadosPessoais(dadosPessoais));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosPessoais> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(dadosPessoaisService.buscarDadosPessoaisById(id));
    }
}
