package com.br.apibarbearia.service;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.apibarbearia.dto.AgendaHorarioServicoDTO;
import com.br.apibarbearia.model.AgendaHorario;
import com.br.apibarbearia.model.Cadeira;
import com.br.apibarbearia.model.Cliente;
import com.br.apibarbearia.model.Funcionario;
import com.br.apibarbearia.model.Horario;
import com.br.apibarbearia.model.ServicoOferecido;
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
		
		return horarioService.verificaDisponibilidadeDoHorario(horarioAgendaServico);
	}

	public AgendaHorarioServicoDTO agendarHorarioServico(AgendaHorarioServicoDTO agendaHorarioServicoDTO) {
		
		try {
			Cliente cliente = clienteService.buscarCliente(agendaHorarioServicoDTO.getCliente().getId());

			Funcionario funcionario = funcionarioService.buscarFuncionario(agendaHorarioServicoDTO.getFuncionario().getId());

			List<ServicoOferecido> servicosOferecidos = servicoOferecidoService.buscaServicosOferecidosByArrayId(agendaHorarioServicoDTO.getServicosOferecidos());
			
			LocalDateTime dataHoraAgendamento = LocalDateTime.now();
			
			Cadeira cadeira = funcionario.getCadeira();
			agendaHorarioServicoDTO.getHorario().setCadeira(cadeira);
			
			Double valorOrcamento = (double)0;
			for (ServicoOferecido aux : servicosOferecidos) {				
				valorOrcamento = valorOrcamento + aux.getPreco();
			}
				
		
			String statusAgendamento = "SOLICITADO";
			
			AgendaHorario agenServico = new AgendaHorario();
			agenServico.setCliente(cliente);
			agenServico.setFuncionario(funcionario);
			agenServico.setDataHoraAgendamento(dataHoraAgendamento);
			agenServico.setStatusAgendamento(statusAgendamento);
			agenServico.setValorOrcamento(valorOrcamento);					
				
			agenServico.setHorario( horarioAgendamento(servicosOferecidos, agendaHorarioServicoDTO.getHorario()));
			agenServico.setServicosOferecidos(servicosOferecidos);
			agenServico = agendaHorarioRepository.save(agenServico);
			
			BeanUtils.copyProperties(agenServico, agendaHorarioServicoDTO);
			

			return agendaHorarioServicoDTO;
		}catch (Exception e) {
			return null;
		}
		
	}

	public AgendaHorario buscarAgendaHorarioById(long id){
	 Optional<AgendaHorario> optional = agendaHorarioRepository.findById(id);
	 return optional.get();
	}
}
