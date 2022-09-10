package com.br.apibarbearia.service;

import com.br.apibarbearia.model.Funcionario;
import com.br.apibarbearia.model.ServicoOferecido;
import com.br.apibarbearia.repository.ServicoOferecidoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoOferecidoService {

    @Autowired
    ServicoOferecidoRepository servicoOferecidoRepository;

    public ServicoOferecido adicionaServico(ServicoOferecido servicoOferecido) {
        return servicoOferecidoRepository.save(servicoOferecido);
    }

    public List<ServicoOferecido> buscarTodosServicos() {
        return servicoOferecidoRepository.findAll();
    }

    public ServicoOferecido buscaPorId(Long id) {
        Optional<ServicoOferecido> servicoOferecido = servicoOferecidoRepository.findById(id);
        return servicoOferecido.get();
    }

    public ServicoOferecido removeServicoPorId(Long id) {
        Optional<ServicoOferecido> funcionarioSalvo = servicoOferecidoRepository.findById(id);

        if (funcionarioSalvo == null) {
            throw new RuntimeException();
        }
        servicoOferecidoRepository.deleteById(id);
        return null;
    }

    public ServicoOferecido alterarServico(Long id, ServicoOferecido servicoOferecido) {

        Optional<ServicoOferecido> servicoSalvo = servicoOferecidoRepository.findById(id);

        if (servicoSalvo == null) {
            throw new RuntimeException();
        }
        BeanUtils.copyProperties(servicoOferecido, servicoSalvo.get());
        return servicoOferecidoRepository.save(servicoSalvo.get());
    }

    public List<ServicoOferecido> buscaServicosOferecidosByArrayId(Long[] id) {
        List<ServicoOferecido> servicoOferecidoList = new ArrayList<>();
        for (Long aLong : id) {
            servicoOferecidoList.add(buscaPorId(aLong));
        }
        return servicoOferecidoList;
    }
}
