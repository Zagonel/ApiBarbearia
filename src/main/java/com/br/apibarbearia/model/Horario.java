package com.br.apibarbearia.model;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.br.apibarbearia.model.enuns.DiaSemana;

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
    
    @OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id_agenda_servico")
    private AgendaServico agendaServico;
}
