package com.br.apibarbearia.model;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="agenda_horario", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AgendaHorario implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;
	
	@OneToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;
	
	@OneToOne
	@JoinColumn(name = "id_funcionario", referencedColumnName = "id")
	private Funcionario funcionario;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "agenda_horario_servico",
	joinColumns = {
			@JoinColumn(name = "id_agenda_horario", referencedColumnName = "id")
	},
	inverseJoinColumns = {
			@JoinColumn(name = "id_servico_oferecido", referencedColumnName = "id")
	})
	private List<ServicoOferecido> servicosOferecidos;
	
	@OneToOne
	@JoinColumn(name = "id_horario", referencedColumnName = "id")
	private Horario horario;
	
	@Column(name="tempo_total_estimado")
	private Time tempoTotalEstimado;

	@Column(name="data_inicio_agendamento")
	private LocalDateTime dataHoraAgendamento;
	
	@Column(name="status_agendamento")
	private String statusAgendamento;
	
	@Column(name="valor_orcamento")
	private Double valorOrcamento;

	@JsonIgnore
	@OneToOne(mappedBy = "agendaHorario")
	private ServicoRealizado servicoRealizado;

}
