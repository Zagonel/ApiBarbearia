package com.br.apibarbearia.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.apibarbearia.dto.AgendaHorarioServicoDTO;
import com.br.apibarbearia.model.AgendaHorario;
import com.br.apibarbearia.service.AgendaHorarioService;

@RestController
@RequestMapping("/controle-agendamento")
public class AgendaHorarioResource {
	
	@Autowired
	private AgendaHorarioService agendaHorarioService;
	
	@PostMapping("/agendar-horario-servico")
    public ResponseEntity<AgendaHorarioServicoDTO> agendarHorarioServico(@RequestBody AgendaHorarioServicoDTO agendaHorarioServicoDTO){
		AgendaHorarioServicoDTO agendaHorarioServicoDTOTeste = agendaHorarioService.agendarHorarioServico(agendaHorarioServicoDTO);
		return ResponseEntity.ok(agendaHorarioServicoDTOTeste);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AgendaHorario> buscarHorarioAgendamento(@PathVariable Long id){
        return ResponseEntity.ok(agendaHorarioService.buscarAgendaHorarioById(id));
    }
}
