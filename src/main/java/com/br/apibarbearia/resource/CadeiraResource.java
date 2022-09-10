package com.br.apibarbearia.resource;

import com.br.apibarbearia.model.Cadeira;
import com.br.apibarbearia.model.Horario;
import com.br.apibarbearia.service.CadeiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadeira")
public class CadeiraResource {

    @Autowired
    CadeiraService cadeiraService;

    @PostMapping("/save")
    public ResponseEntity<Cadeira> salvarCadeira(@RequestBody Cadeira cadeira){
        return ResponseEntity.ok(cadeiraService.salvarCadeira(cadeira));
    }

    @GetMapping("/find/all")
    public List<Cadeira> findAllHorario() {
        return cadeiraService.buscarTodasCadeiras();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Cadeira> findCadeiraById(@PathVariable Long id) {
        return ResponseEntity.ok(cadeiraService.buscarCadeiraById(id));
    }

    @PostMapping("/updade/{id}")
    public ResponseEntity<Cadeira> alterarCadeiraById(@PathVariable Long id , @RequestBody Cadeira cadeira){
        return ResponseEntity.ok(cadeiraService.alterarCadeira(id ,cadeira));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Cadeira> removerCadeiraById(@PathVariable Long id){
        return ResponseEntity.ok(cadeiraService.removeCadeiraById(id));
    }
}
