package com.br.apibarbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.apibarbearia.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
