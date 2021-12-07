package br.com.controle.service;

import br.com.controle.dto.ContasDTO;
import br.com.controle.entity.ContasEntity;

import java.util.List;

public interface ContasService {
	
    ContasDTO obterContaPorStatus(String status);
    
    List<ContasDTO> trazerTodasAsContas();
}
