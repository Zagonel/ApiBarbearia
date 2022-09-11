package com.br.apibarbearia.repository;

import java.sql.Time;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.apibarbearia.model.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long>{

	@Query("SELECT h FROM Horario h "
			+ "WHERE 1=1 "
			+ "AND (h IS NOT NULL)"
			+ "AND (h.dataAgendamento = :dataAgendamento) "
			+ "AND ((h.horaInicio BETWEEN :horaInicio AND :horaFim) OR (h.horaFim BETWEEN :horaInicio AND :horaFim))"
			+ "AND (h.cadeira.id = :idCadeira) ")
	Optional<Horario> buscarHorarioExistente(Long idCadeira, Time horaInicio, Time horaFim, Date dataAgendamento);
}
