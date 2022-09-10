package com.br.apibarbearia.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

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
@Table(name="dados_pessoais", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DadosPessoais implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @Column
    private String nome;
    
    @Column
    private Long cpf;

    @Column(name="data_nascimento")
    private Date dataNascimento;

}
