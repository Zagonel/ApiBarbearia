package com.br.apibarbearia.resource;

import com.br.apibarbearia.dto.FiltroDeConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.apibarbearia.dto.AgendaHorarioServicoDTO;
import com.br.apibarbearia.model.AgendaHorario;
import com.br.apibarbearia.service.AgendaHorarioService;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/find/data")
    public List<AgendaHorario> buscarHorarioAgendamentoBetweenData(@RequestBody FiltroDeConsulta filtroDeConsulta){
        return agendaHorarioService.buscarDataAgendamentoByData(filtroDeConsulta.getDataInicio(),filtroDeConsulta.getDataFinal());
    }

    @GetMapping("/find/cpf")
    public List<AgendaHorario> BuscarAgendaHorarioByCpfClienteOrCpfFuncionario(@RequestBody FiltroDeConsulta filtroDeConsulta){
        return agendaHorarioService.BuscarAgendaHorarioByCpfClienteOrCpfFuncionario(filtroDeConsulta.getCpfCliente(),filtroDeConsulta.getCpfFuncionario());
    }
}
