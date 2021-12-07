package br.com.controle.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle.dto.ContasDTO;
import br.com.controle.service.ContasService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contas")
public class ControleContasController {

    private final ContasService contasService;

    @GetMapping
    public ResponseEntity<List<ContasDTO>> trazerTodasContas() {
        return ResponseEntity.ok(contasService.trazerTodasAsContas());
    }

    @GetMapping("{status}")
    public ResponseEntity<ContasDTO> obterContaPorStatus(@RequestBody String status) {
        return ResponseEntity.ok(contasService.obterContaPorStatus("aqui"));
    }
}

