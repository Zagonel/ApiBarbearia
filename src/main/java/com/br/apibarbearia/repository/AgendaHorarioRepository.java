package com.br.apibarbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.apibarbearia.model.AgendaHorario;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendaHorarioRepository extends JpaRepository<AgendaHorario, Long>{

    @Query("SELECT h FROM AgendaHorario h "
            + "WHERE h.dataHoraAgendamento BETWEEN :dataInicio AND :dataFinal")
    List<AgendaHorario> buscarAgendaHorarioBetweenData(LocalDateTime dataInicio, LocalDateTime dataFinal);

    @Query("SELECT h FROM AgendaHorario h "
            + "WHERE 1=1 "
            + "AND (:cpfCliente IS NOT NULL)"
            + "AND (h.cliente.dadosPessoais.cpf = :cpfCliente)"
            + "AND (:cpfFuncionario IS NOT NULL)"
            + "AND (h.funcionario.dadosPessoais.cpf = :cpfFuncionario)")
    List<AgendaHorario> BuscarAgendaHorarioByCpfClienteOrCpfFuncionario(String cpfCliente, String cpfFuncionario);
}
