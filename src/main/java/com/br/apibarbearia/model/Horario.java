package com.br.apibarbearia.model;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.br.apibarbearia.model.enuns.DiaSemana;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="horario", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Horario implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @Column(name="dia_semana")
    private DiaSemana diaSemana;
    
    @Column(name="hora_inicio")
    private Time horaInicio;

    @Column(name="hora_fim")
    private Time horaFim;
    
	@Column(name="tempo_total_estimado")
	private Time tempoTotalEstimado;
    
    @Column(name="data_agendamento")
    private Date dataAgendamento;
    
    @OneToOne
	@JoinColumn(name = "id_cadeira", referencedColumnName = "id")
    private Cadeira cadeira;

    @JsonIgnore
    @OneToOne(mappedBy = "horario")
    private AgendaHorario agendaServico;
}
