package com.br.apibarbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.apibarbearia.model.AgendaHorario;

@Repository
public interface AgendaHorarioRepository extends JpaRepository<AgendaHorario, Long>{

}
