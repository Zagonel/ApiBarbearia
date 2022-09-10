package com.br.apibarbearia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="servico", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ServicoRealizado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id")
    private Funcionario funcionario;

    @OneToOne
    @JoinColumn(name = "id_cadeira", referencedColumnName = "id")
    private Cadeira cadeira;

    @OneToOne
    @JoinColumn(name = "id_horario", referencedColumnName = "id")
    private Horario horario;

    @OneToMany
    @JoinColumn(name = "id_servicos", referencedColumnName = "id")
    private List<Servico> servicos;

    @Column(name = "valor_total")
    private double valorTotal;

    @Column(name="data_hora_conclusao")
    private LocalDateTime dataHoraConclusao;
}
