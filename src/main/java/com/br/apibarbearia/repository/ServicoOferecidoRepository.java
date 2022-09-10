package com.br.apibarbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.apibarbearia.model.ServicoOferecido;

@Repository
public interface ServicoOferecidoRepository extends JpaRepository<ServicoOferecido, Long>{

}
