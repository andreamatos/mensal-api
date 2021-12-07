package br.com.controle.dto;

import br.com.controle.entity.ContasEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContasDTO {

    private String titulo;
    private String valor;
    private String mes;
    private String status;

    public static ContasDTO contasDTO (ContasEntity contasEntity) {
        return ContasDTO.builder()
            .titulo(contasEntity.getTitulo())
            .valor(contasEntity.getValor())
            .mes(contasEntity.getMes())
            .status(contasEntity.getStatus()).build();

    }
}
