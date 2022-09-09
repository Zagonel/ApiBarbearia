package com.br.apibarbearia.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="cadeiras", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cadeiras {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @Column
    private int numrCadeira;


}
