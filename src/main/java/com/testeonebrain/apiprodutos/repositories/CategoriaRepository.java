package com.testeonebrain.apiprodutos.repositories;

import com.testeonebrain.apiprodutos.dtos.CategoriaDTO;
import com.testeonebrain.apiprodutos.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
    CategoriaModel findById(CategoriaDTO categoriaDTO);
}
