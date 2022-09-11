package com.br.apibarbearia.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.apibarbearia.model.AgendaHorario;
import com.br.apibarbearia.service.AgendaHorarioService;

@RestController
@RequestMapping("/controle-agendamento")
public class AgendaHorarioResource {
	
	@Autowired
	private AgendaHorarioService agendaHorarioService;
	
	@PostMapping("/agendar-horario-servico")
    public ResponseEntity<AgendaHorario> agendarHorarioServico(@RequestBody AgendaHorario agendaServico){
        return ResponseEntity.ok(agendaHorarioService.agendarHorarioServico(agendaServico));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AgendaHorario> buscarHorarioAgendamento(@PathVariable Long id){
        return ResponseEntity.ok(agendaHorarioService.buscarAgendaHorarioById(id));
    }
}
