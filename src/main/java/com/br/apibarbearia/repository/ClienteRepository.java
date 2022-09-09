package com.br.apibarbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.apibarbearia.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
