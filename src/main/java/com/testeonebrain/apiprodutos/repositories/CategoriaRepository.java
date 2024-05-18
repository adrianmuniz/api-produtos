package com.testeonebrain.apiprodutos.repositories;

import com.testeonebrain.apiprodutos.dtos.CategoriaDTO;
import com.testeonebrain.apiprodutos.model.CategoriaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
    CategoriaModel findById(CategoriaDTO categoriaDTO);

    @Query("SELECT obj FROM CategoriaModel obj WHERE obj.ativo = true")
    Page<CategoriaModel> findAll(Pageable pageable);
}
