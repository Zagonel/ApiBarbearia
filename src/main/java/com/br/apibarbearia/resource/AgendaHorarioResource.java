package com.br.apibarbearia.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
