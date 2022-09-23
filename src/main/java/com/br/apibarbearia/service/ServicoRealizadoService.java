package com.br.apibarbearia.service;

import com.br.apibarbearia.dto.ServicoRealizadoDto;
import com.br.apibarbearia.model.AgendaHorario;
import com.br.apibarbearia.model.ServicoOferecido;
import com.br.apibarbearia.model.ServicoRealizado;
import com.br.apibarbearia.model.enuns.StatusAgendamento;
import com.br.apibarbearia.repository.ServicoRealizadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicoRealizadoService {

    @Autowired
    ServicoRealizadoRepository servicoRealizadoRepository;

    @Autowired
    AgendaHorarioService agendaHorarioService;

    @Autowired
    ServicoOferecidoService servicoOferecidoService;

    private final ModelMapper mapper;

    @Autowired
    public ServicoRealizadoService(ServicoRealizadoRepository servicoRealizadoRepository, ModelMapper mapper){
        this.servicoRealizadoRepository = servicoRealizadoRepository;
        this.mapper = mapper;
    }

    public ServicoRealizado salvarServicoRealizado(Long id, ServicoRealizadoDto servicoRealizadoDto){
        ServicoRealizado servicoRealizado = new ServicoRealizado();
        servicoRealizado.setServicosOferecidos(servicoOferecidoService.buscaServicosOferecidosByArrayId(servicoRealizadoDto.getServicosOferecidos()));
        servicoRealizado.setAgendaHorario(agendaHorarioService.buscarAgendaHorarioById(id));
        servicoRealizado.getAgendaHorario().setStatusAgendamento(String.valueOf(StatusAgendamento.CONCLUIDO));
        servicoRealizado.setDataHoraConclusao(LocalDateTime.now());
        servicoRealizado.setValorTotal(servicoRealizadoDto.getValorTotal());
        return servicoRealizadoRepository.save(servicoRealizado);
    }

    public List<ServicoRealizado> buscarServicoRealizadoByCliente(String cpf, int id){
        //futaramente fazer um erro personalizado.
            return servicoRealizadoRepository.buscarServicoRealizadoCliente(cpf, Objects.requireNonNull(StatusAgendamento.getEnumById(id)).name()).get();
       }

}
