package br.com.controle.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import br.com.controle.entity.ContasEntity;

@EnableScan
public interface ContasRepository extends CrudRepository<ContasEntity, Object> {

    ContasEntity findAllByStatus(String status);

    List<ContasEntity> findAll();
}
