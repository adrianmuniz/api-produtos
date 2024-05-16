package com.testeonebrain.apiprodutos.repositories;

import com.testeonebrain.apiprodutos.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
