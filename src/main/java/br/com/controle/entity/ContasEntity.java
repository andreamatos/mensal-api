package br.com.controle.entity;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import br.com.controle.dto.ContasDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "monthly-bills")
public class ContasEntity implements Serializable {

	@DynamoDBHashKey(attributeName = "Titulo")
    private String titulo;

	@DynamoDBAttribute(attributeName = "Valor")
    private String valor;

	@DynamoDBAttribute(attributeName = "Mes")
    private String mes;

	@DynamoDBAttribute(attributeName = "Status")
    private String status;

    public static ContasEntity contasEntity (ContasDTO contasDTO) {
        return ContasEntity.builder()
            .titulo(contasDTO.getTitulo())
            .valor(contasDTO.getValor())
            .mes(contasDTO.getMes())
            .status(contasDTO.getStatus()).build();
    }

}
