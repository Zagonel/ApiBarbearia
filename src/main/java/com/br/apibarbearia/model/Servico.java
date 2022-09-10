package com.br.apibarbearia.model;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="servico", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Servico implements Serializable {

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
	
	@Column (name="tempo_execucao")
	private Time tempoExecucaoServico;
	
}
