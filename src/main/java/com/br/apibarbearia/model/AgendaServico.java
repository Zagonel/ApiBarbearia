package com.br.apibarbearia.model;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="agenda_servico", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AgendaServico implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;
	
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id_cliente")
    private Cliente cliente;
	
	@OneToMany
	@JoinColumn(name = "id", referencedColumnName = "id_servico")
	private List<Servico> servicos;

	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id_funcionario")
	private Funcionario funcionario;
	
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id_cadeira")
	private Cadeira cadeira;
		
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id_horario")
	private Horario horarios;
	
	@Column(name="tempo_total_estimado")
	private Time tempoTotalEstimado;

	@Column(name="data_hora_agendamento")
	private LocalDateTime dataHoraAgendamento;
	
	@Column(name="status_agendamento")
	private String statusAgendamento;
	
	@Column(name="valor_orcamento")
	private Double valorOrcamento;
	

}