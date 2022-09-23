package com.br.apibarbearia.repository;

import com.br.apibarbearia.model.ServicoRealizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServicoRealizadoRepository extends JpaRepository<ServicoRealizado, Long> {

    @Query("SELECT c FROM ServicoRealizado c "
            + "WHERE 1=1 "
            + "AND (c IS NOT NULL)"
            + "AND (c.agendaHorario.cliente.dadosPessoais.cpf = :cpf)"
            + "AND (c.agendaHorario.statusAgendamento = :status)")
    Optional<List<ServicoRealizado>> buscarServicoRealizadoCliente(String cpf, String status);
}