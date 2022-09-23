package com.br.apibarbearia.model;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.br.apibarbearia.model.enuns.NivelPermissao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cliente", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

	@OneToOne
	@JoinColumn(name = "id_dados_pessoais", referencedColumnName = "id")
    private DadosPessoais dadosPessoais;
    
    @Column
    private String usuario;

    @JsonIgnore
    @Column
    private String senha;
    
    @Column(name = "cont_servic_conclu")
    private int contServicosConcluidos;

    @JsonIgnore
    @Column(name="nivel_permissao")
    private NivelPermissao nivelPermissao;

}
