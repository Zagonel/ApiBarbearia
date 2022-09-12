package com.br.apibarbearia.dto;

import com.br.apibarbearia.model.ServicoOferecido;
import lombok.Data;

import java.util.List;

@Data
public class ServicoRealizadoDto{
    private final List<ServicoOferecido> servicosOferecidos;
    private final double valorTotal;
}
