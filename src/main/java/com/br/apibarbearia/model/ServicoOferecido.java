package com.br.apibarbearia.model;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="servicos_oferecido", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ServicoOferecido implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;
	
	@Column(name="nome_servico")
    private String nomeServico;
	
	@Column(name="descricao_servico")
	private String descricaoServico;
	
	@Column
	private Double preco;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "servicosOferecidos", fetch = FetchType.LAZY)
	private List<AgendaHorario> agendaServicos;
	
	@Column (name="tempo_execucao")
	private Time tempoExecucaoServico;
	
}
