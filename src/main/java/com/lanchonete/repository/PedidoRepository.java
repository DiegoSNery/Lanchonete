package com.lanchonete.repository;

import com.lanchonete.domain.pedido.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

//        @Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf")
//        Cliente findByCpf(@Param("cpf") String cpf);
}
