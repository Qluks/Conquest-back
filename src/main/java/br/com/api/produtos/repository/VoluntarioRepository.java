package br.com.api.produtos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.produtos.model.VoluntarioModel;

@Repository
public interface VoluntarioRepository extends CrudRepository<VoluntarioModel, Long> {

}
