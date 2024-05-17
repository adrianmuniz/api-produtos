package com.testeonebrain.apiprodutos.repositories;

import com.testeonebrain.apiprodutos.model.ProdutoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {


    @Query("SELECT obj FROM ProdutoModel obj WHERE LOWER(obj.marca) LIKE LOWER(CONCAT('%', :marca, '%'))")
    Page<ProdutoModel> findByMarca(String marca, Pageable pageable);

    @Query("SELECT obj FROM ProdutoModel obj WHERE LOWER(obj.categorias) LIKE LOWER(CONCAT('%', :categoria, '%'))")
    Page<ProdutoModel> findByCategoria(String categoria, Pageable pageable);
}
