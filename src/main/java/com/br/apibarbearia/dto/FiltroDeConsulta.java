package com.br.apibarbearia.dto;

import com.br.apibarbearia.model.ServicoOferecido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FiltroDeConsulta {

    private String dataInicio;
    private String dataFinal;
    //rever como retornar esse campo no json do agenda horario
    private List<ServicoOferecido> servicoOferecidoList;
    private String cpfFuncionario;
    private String cpfCliente;
    private int idStatusAgendamento;
}
