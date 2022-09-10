package com.br.apibarbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.apibarbearia.model.Cadeira;

@Repository
public interface CadeiraRepository extends JpaRepository<Cadeira, Long>{

}
