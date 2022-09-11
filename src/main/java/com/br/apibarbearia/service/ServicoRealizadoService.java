package com.br.apibarbearia.service;

import com.br.apibarbearia.model.AgendaHorario;
import com.br.apibarbearia.model.ServicoOferecido;
import com.br.apibarbearia.model.ServicoRealizado;
import com.br.apibarbearia.repository.ServicoRealizadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoRealizadoService {

    @Autowired
    ServicoRealizadoRepository servicoRealizadoRepository;

    @Autowired
    AgendaHorarioService agendaHorarioService;

    @Autowired
    ServicoOferecidoService servicoOferecidoService;


    public ServicoRealizado salvarServicoRealizado(Long valor,Long idAgendaHorario){
        List<ServicoOferecido> servicoOferecidoList = new ArrayList<>();
        servicoOferecidoList.add(servicoOferecidoService.buscaPorId((long) 14));

        ServicoRealizado servicoRealizado = new ServicoRealizado();

        //List<ServicoOferecido> servicoOferecidos = servicoOferecidoService.buscaServicosOferecidosByArrayId(servicoOferecidoList);
        servicoRealizado.setServicosOferecidos(servicoOferecidoList);
        servicoRealizado.setAgendaHorario(agendaHorarioService.buscarAgendaHorarioById(idAgendaHorario));
        servicoRealizado.setDataHoraConclusao(LocalDateTime.now());
        servicoRealizado.setValorTotal(valor);
        return servicoRealizadoRepository.save(servicoRealizado);
    }
}
