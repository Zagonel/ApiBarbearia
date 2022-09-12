package com.br.apibarbearia.service;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.apibarbearia.dto.AgendaHorarioServicoDTO;
import com.br.apibarbearia.model.AgendaHorario;
import com.br.apibarbearia.model.Horario;
import com.br.apibarbearia.model.ServicoOferecido;
import com.br.apibarbearia.model.enuns.DiaSemana;
import com.br.apibarbearia.model.enuns.StatusAgendamento;
import com.br.apibarbearia.repository.AgendaHorarioRepository;

@Service
public class AgendaHorarioService {

	@Autowired
	private AgendaHorarioRepository agendaHorarioRepository;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private FuncionarioService funcionarioService;


	@Autowired
	private ServicoOferecidoService servicoOferecidoService;
	
	@Autowired
	private HorarioService horarioService;
	
	public AgendaHorarioServicoDTO agendarHorarioServico(AgendaHorarioServicoDTO agendaHorarioServicoDTO) {
		
		try {
			
			AgendaHorario agendaHorario = new AgendaHorario();
			agendaHorario.setCliente(clienteService.buscarCliente(agendaHorarioServicoDTO.getCliente().getId()));
			agendaHorario.setFuncionario(funcionarioService.buscarFuncionario(agendaHorarioServicoDTO.getFuncionario().getId()));
			agendaHorario.setDataHoraAgendamento(LocalDateTime.now());
			agendaHorario.setStatusAgendamento(StatusAgendamento.SOLICITADO.toString());
			agendaHorario.setServicosOferecidos(servicoOferecidoService.buscaServicosOferecidosByArrayId(agendaHorarioServicoDTO.getServicosOferecidos()));
			agendaHorarioServicoDTO.getHorario().setCadeira(agendaHorario.getFuncionario().getCadeira());
			agendaHorario.setHorario(horarioAgendamento(
					servicoOferecidoService.buscaServicosOferecidosByArrayId(
							agendaHorarioServicoDTO.getServicosOferecidos()), 
					agendaHorarioServicoDTO.getHorario()
					));		
			agendaHorario.setValorOrcamento(calculaOrcamento(agendaHorarioServicoDTO.getServicosOferecidos()));					
			
			agendaHorario = agendaHorarioRepository.save(agendaHorario);	
			BeanUtils.copyProperties(agendaHorario, agendaHorarioServicoDTO);
			return agendaHorarioServicoDTO;
		}catch (Exception e) {
			return null;
		}
		
	}
	
	public AgendaHorario buscarAgendaHorarioById(long id){
		Optional<AgendaHorario> optional = agendaHorarioRepository.findById(id);
		return optional.get();
	}
	
	private Double calculaOrcamento(List<ServicoOferecido> servicosOferecidos) {
		Double valorOrcamento = (double)0;
		for (ServicoOferecido aux : servicoOferecidoService.buscaServicosOferecidosByArrayId(servicosOferecidos)) {				
			valorOrcamento = valorOrcamento + aux.getPreco();
		}
		return valorOrcamento;
	}
	
	private Horario horarioAgendamento(List<ServicoOferecido> servicosOferecidos, Horario horarioAgendaServico) {
		
		Duration tempoTotalExecucaoServico = Duration.ZERO;
		
		for (ServicoOferecido aux : servicosOferecidos) {
			String tempo = aux.getTempoExecucaoServico().toString();
			String[] partes = tempo.split(":");
			tempoTotalExecucaoServico = tempoTotalExecucaoServico			      
			        .plusHours(Long.parseLong(partes[0]))			        
			        .plusMinutes(Long.parseLong(partes[1]))
			        .plusSeconds(Long.parseLong(partes[2]));		
		}
		
		Duration horaFinal = tempoTotalExecucaoServico;
		String[] partesHoraInicial = horarioAgendaServico.getHoraInicio().toString().split(":");
		horaFinal = horaFinal			      
		        .plusHours(Long.parseLong(partesHoraInicial[0]))			        
		        .plusMinutes(Long.parseLong(partesHoraInicial[1]))
		        .plusSeconds(Long.parseLong(partesHoraInicial[2]));
		
		horarioAgendaServico.setTempoTotalEstimado(Time.valueOf(
				String.format("%02d:%02d:%02d", 
				(tempoTotalExecucaoServico.toDaysPart() * 24) + tempoTotalExecucaoServico.toHoursPart(),
				tempoTotalExecucaoServico.toMinutesPart(), tempoTotalExecucaoServico.toSecondsPart())));
		
		horarioAgendaServico.setHoraFim(Time.valueOf(
				String.format("%02d:%02d:%02d", (horaFinal.toDaysPart() * 24) + horaFinal.toHoursPart(),
				horaFinal.toMinutesPart(), horaFinal.toSecondsPart())));
		
		DiaSemana[] dia = DiaSemana.values();
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(horarioAgendaServico.getDataAgendamento());
		int diaDaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);
		for(DiaSemana numDia : dia) {
			if(numDia.getnumDia() == diaDaSemana) {
				horarioAgendaServico.setDiaSemana(numDia);
			}
		}
		
		
		return horarioService.verificaDisponibilidadeDoHorario(horarioAgendaServico);
	}

}
