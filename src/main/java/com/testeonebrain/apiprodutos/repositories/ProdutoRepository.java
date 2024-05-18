package com.testeonebrain.apiprodutos.repositories;

import com.testeonebrain.apiprodutos.model.ProdutoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {


    @Query("SELECT obj FROM ProdutoModel obj WHERE LOWER(obj.marca) LIKE LOWER(CONCAT('%', :marca, '%'))")
    Page<ProdutoModel> findByMarca(String marca, Pageable pageable);

    @Query("SELECT obj FROM ProdutoModel obj INNER JOIN obj.categorias cat WHERE cat.id = :categoriaId")
    Page<ProdutoModel> findByCategoria(Long categoriaId, Pageable pageable);

    @Query("SELECT obj FROM ProdutoModel obj WHERE obj.ativo = true")
    Page<ProdutoModel> findAll(Pageable pageable);

}
