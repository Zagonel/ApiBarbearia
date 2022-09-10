package com.br.apibarbearia.repository;

import com.br.apibarbearia.model.ServicoRealizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRealizadoRepository extends JpaRepository<ServicoRealizado, Long> {
}