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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="funcionario", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Funcionario implements Serializable {

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

    @Column
    private String senha;

    @Column(name="nivel_permissao")
    private NivelPermissao nivelPermissao;
	
}
