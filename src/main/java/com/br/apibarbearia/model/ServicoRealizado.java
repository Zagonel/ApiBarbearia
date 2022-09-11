package com.br.apibarbearia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="servicos_realizados", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ServicoRealizado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "servicos_realizados_oferecidos",
            joinColumns = {
                    @JoinColumn(name = "id_servicos_realizados", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_servicos_oferecidos", referencedColumnName = "id")
            })
    private List<ServicoOferecido> servicosOferecidos;

    @Column(name = "valor_total")
    private double valorTotal;

    @Column(name="data_hora_conclusao")
    private LocalDateTime dataHoraConclusao;

    @OneToOne
    @JoinColumn(name="id_agenda_horario", referencedColumnName = "id")
    private AgendaHorario agendaHorario;
}
