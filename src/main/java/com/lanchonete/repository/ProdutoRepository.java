package com.lanchonete.repository;

import com.lanchonete.domain.cardapio.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    @Query("SELECT p FROM Produto p WHERE p.categoria = :categoria")
    Produto findByCategoria(@Param("categoria") String categoria);
}
