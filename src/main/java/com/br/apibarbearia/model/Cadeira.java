package com.br.apibarbearia.model;


import java.io.Serial;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.br.apibarbearia.model.enuns.StatusCadeira;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cadeiras", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cadeira implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @Column(name = "numero_cadeira")
    private int numrCadeira;

    @Column(name = "status")
    private StatusCadeira status;

}
