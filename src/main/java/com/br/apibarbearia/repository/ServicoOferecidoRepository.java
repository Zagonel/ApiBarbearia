package com.br.apibarbearia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.apibarbearia.model.ServicoOferecido;

@Repository
public interface ServicoOferecidoRepository extends JpaRepository<ServicoOferecido, Long>{
	
	@Query("SELECT sf FROM ServicoOferecido sf "
			+ "WHERE sf.id IN (:idServicos)")
	List<ServicoOferecido> buscarServicosOferecidos(List<Long> idServicos);
}
