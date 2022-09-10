package com.br.apibarbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.apibarbearia.model.AgendaServico;

@Repository
public interface AgendaServicoRepository extends JpaRepository<AgendaServico, Long>{

}
