package com.br.apibarbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.apibarbearia.model.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long>{

}
