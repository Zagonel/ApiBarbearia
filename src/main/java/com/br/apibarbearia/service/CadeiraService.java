package com.br.apibarbearia.service;

import com.br.apibarbearia.model.Cadeira;
import com.br.apibarbearia.model.Horario;
import com.br.apibarbearia.repository.CadeiraRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadeiraService {

    @Autowired
    CadeiraRepository cadeiraRepository;

    public Cadeira salvarCadeira(Cadeira cadeira){
        return cadeiraRepository.save(cadeira);
    }

    public List<Cadeira> buscarTodasCadeiras(){
        return cadeiraRepository.findAll();
    }

    public Cadeira buscarCadeiraById(Long id){
        Optional<Cadeira> cadeira = cadeiraRepository.findById(id);
        return cadeira.get();
    }

    public Cadeira removeCadeiraById(Long id){
        Optional<Cadeira> cadeira = cadeiraRepository.findById(id);
        if(cadeira == null){
            throw new RuntimeException();
        }
        cadeiraRepository.deleteById(id);
        return null;
    }

    public Cadeira alterarCadeira(Long id, Cadeira cadeira) {

        Optional<Cadeira> cadeiraSalva = cadeiraRepository.findById(id);

        if(cadeiraSalva == null ) {
            throw new RuntimeException();
        }
        BeanUtils.copyProperties(cadeira, cadeiraSalva.get());
        return cadeiraRepository.save(cadeiraSalva.get());
    }
}
