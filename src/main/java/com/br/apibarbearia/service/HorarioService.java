package com.br.apibarbearia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.apibarbearia.model.Horario;
import com.br.apibarbearia.repository.HorarioRepository;

@Service
public class HorarioService {
	
	@Autowired
    HorarioRepository horarioRepository;

    public Horario verificaDisponibilidadeDoHorario(Horario horario){
    	
    	
    	
//    	Optional<Horario> horarioExistente = ;
    	
    	if(!(horarioRepository.buscarHorarioExistente(horario.getCadeira().getId(), horario.getHoraInicio(), horario.getHoraFim(), horario.getDataAgendamento()).isEmpty())) {
    		return null;
    	}
    	
    	return horarioRepository.save(horario);
    }
    
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
