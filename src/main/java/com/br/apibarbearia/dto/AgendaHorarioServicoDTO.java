package com.br.apibarbearia.dto;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

import com.br.apibarbearia.model.Cliente;
import com.br.apibarbearia.model.Funcionario;
import com.br.apibarbearia.model.Horario;
import com.br.apibarbearia.model.ServicoOferecido;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AgendaHorarioServicoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	
	private Funcionario funcionario;
	
	private List<ServicoOferecido> servicosOferecidos;
	
	private Horario horario;
	
	private LocalDateTime dataHoraAgendamento;
	
	private String statusAgendamento;
	
	private Double valorOrcamento;
	
}
