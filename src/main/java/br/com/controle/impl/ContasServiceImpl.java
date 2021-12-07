package br.com.controle.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.controle.dto.ContasDTO;
import br.com.controle.repository.ContasRepository;
import br.com.controle.service.ContasService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class ContasServiceImpl implements ContasService {

    private final ContasRepository contasRepository;

    @Override
    public ContasDTO obterContaPorStatus(String status) {
        return ContasDTO.contasDTO(contasRepository.findAllByStatus(status));
    }

    @Override
    public List<ContasDTO> trazerTodasAsContas() {
        final List<ContasDTO> list = new ArrayList<>();
        var procurarContas = contasRepository.findAll();
        procurarContas.forEach(it -> list.add(ContasDTO.contasDTO(it)));
        return list;
    }
}
