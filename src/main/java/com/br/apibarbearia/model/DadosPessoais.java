package com.br.apibarbearia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="dados_pessoais", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DadosPessoais implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @Column
    private String nome;
    @Column
    private String cpf;

    @Column(name="data_nascimento")
    private Date dataNascimento;

}
