package com.br.apibarbearia.service;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.apibarbearia.model.AgendaHorario;
import com.br.apibarbearia.model.Cadeira;
import com.br.apibarbearia.model.Cliente;
import com.br.apibarbearia.model.Funcionario;
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

	public AgendaHorario agendarHorarioServico(AgendaHorario agendaHorario) {
		
		try {
			Cliente cliente = clienteService.buscarCliente(agendaHorario.getCliente().getId());

			Funcionario funcionario = funcionarioService.buscarFuncionario(agendaHorario.getFuncionario().getId());

			List<ServicoOferecido> servicoslist = new ArrayList<ServicoOferecido>();
			
			servicoslist.add(new ServicoOferecido());
			servicoslist.get(0).setId((long) 14);
			servicoslist.add(new ServicoOferecido());
			servicoslist.get(1).setId((long) 15);
			
			List<ServicoOferecido> servicos = servicoOferecidoService.buscaServicosOferecidosByArrayId(servicoslist);
			
			Cadeira cadeira = funcionario.getCadeira();
			
			Duration tempoTotal = Duration.ZERO;
			Double valorOrcamento = (double)0;
			
			for (ServicoOferecido aux : servicos) {
				String tempo = aux.getTempoExecucaoServico().toString();
				String[] partes = tempo.split(":");
				tempoTotal = tempoTotal			      
				        .plusHours(Long.parseLong(partes[0]))			        
				        .plusMinutes(Long.parseLong(partes[1]))
				        .plusSeconds(Long.parseLong(partes[2]));
				
				valorOrcamento = valorOrcamento + aux.getPreco();
			}
			String totalFormatado = String.format("%02d:%02d:%02d", (tempoTotal.toDaysPart() * 24) + tempoTotal.toHoursPart(),
					tempoTotal.toMinutesPart(), tempoTotal.toSecondsPart());
			
			Duration tempoFinal = tempoTotal;
			String[] partesI = agendaHorario.getHorario().getHoraInicio().toString().split(":");
			tempoFinal = tempoFinal			      
			        .plusHours(Long.parseLong(partesI[0]))			        
			        .plusMinutes(Long.parseLong(partesI[1]))
			        .plusSeconds(Long.parseLong(partesI[2]));
			
			String tempoFinalFormatado = String.format("%02d:%02d:%02d", (tempoFinal.toDaysPart() * 24) + tempoFinal.toHoursPart(),
					tempoFinal.toMinutesPart(), tempoFinal.toSecondsPart());
			
			LocalDateTime dataHoraAgendamento = LocalDateTime.now();
		
			String statusAgendamento = "SOLICITADO";
			
			AgendaHorario agenServico = new AgendaHorario();
			agenServico.setCliente(cliente);
			agenServico.setFuncionario(funcionario);
			agenServico.setTempoTotalEstimado(Time.valueOf(totalFormatado));
			agenServico.setDataHoraAgendamento(dataHoraAgendamento);
			agenServico.setStatusAgendamento(statusAgendamento);
			agenServico.setValorOrcamento(valorOrcamento);
			
			
			
			agendaHorario.getHorario().setCadeira(cadeira);
			agendaHorario.getHorario().setHoraFim(Time.valueOf(tempoFinalFormatado));
			
			
				
			agenServico.setHorario(horarioService.verificaDisponibilidadeDoHorario(agendaHorario.getHorario()));
			agenServico.setServicosOferecidos(servicos);
			agenServico = agendaHorarioRepository.save(agenServico);

			return agenServico;
		}catch (Exception e) {
			return null;
		}
		
	}
}
