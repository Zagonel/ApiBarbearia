package com.br.apibarbearia.service;

import com.br.apibarbearia.model.AgendaServico;
import com.br.apibarbearia.model.Horario;
import com.br.apibarbearia.model.ServicoOferecido;
import com.br.apibarbearia.repository.HorarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    HorarioRepository horarioRepository;

    public Horario salvarHorario(Horario horario){
        return horarioRepository.save(horario);
    }

    public List<Horario> buscarTodosHorario(){
        return horarioRepository.findAll();
    }

    public Horario buscarHorarioById(Long id){
        Optional<Horario> horario = horarioRepository.findById(id);
        return horario.get();
    }

    public Horario removeHorarioById(Long id){
        Optional<Horario> horario = horarioRepository.findById(id);
        if(horario == null){
            throw new RuntimeException();
        }
        horarioRepository.deleteById(id);
        return null;
    }

    public Horario alterarHorario(Long id, Horario horario) {

        Optional<Horario> horarioSalvo = horarioRepository.findById(id);

        if(horarioSalvo == null ) {
            throw new RuntimeException();
        }
        BeanUtils.copyProperties(horario, horarioSalvo.get());
        return horarioRepository.save(horarioSalvo.get());
    }
}
