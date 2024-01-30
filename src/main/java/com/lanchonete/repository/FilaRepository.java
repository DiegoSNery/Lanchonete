package com.lanchonete.repository;

import com.lanchonete.domain.pedido.Fila;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilaRepository extends CrudRepository<Fila, Long> {


}
