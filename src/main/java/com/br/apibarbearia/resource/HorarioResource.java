package com.br.apibarbearia.resource;

import com.br.apibarbearia.model.Horario;
import com.br.apibarbearia.model.ServicoOferecido;
import com.br.apibarbearia.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horario")
public class HorarioResource {

    @Autowired
    HorarioService horarioService;

    @PostMapping("/save")
    public ResponseEntity<Horario> salvarHorario(@RequestBody Horario horario){
        return ResponseEntity.ok(horarioService.salvarHorario(horario));
    }

    @GetMapping("/find/all")
    public List<Horario> findAllHorario() {
        return horarioService.buscarTodosHorario();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Horario> findHorarioById(@PathVariable Long id) {
        return ResponseEntity.ok(horarioService.buscarHorarioById(id));
    }

    @PostMapping("/updade/{id}")
    public ResponseEntity<Horario> alterarHorarioById(@PathVariable Long id , @RequestBody Horario horario){
        return ResponseEntity.ok(horarioService.alterarHorario(id ,horario));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Horario> removerHorarioById(@PathVariable Long id){
        return ResponseEntity.ok(horarioService.removeHorarioById(id));
    }
}
