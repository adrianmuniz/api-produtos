package com.testeonebrain.apiprodutos.service;

import com.testeonebrain.apiprodutos.dtos.ProdutoDTO;
import com.testeonebrain.apiprodutos.model.ProdutoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProdutoService {
    ProdutoDTO save(ProdutoDTO produtoDTO);

    Page<ProdutoModel> findAll(Pageable pageable);

    Optional<ProdutoModel> findById(Long produtoId);

    ProdutoDTO update(Long productId, ProdutoDTO productDto);

    void delete(ProdutoModel produtoModel);

    Page<ProdutoModel> findByMarca(String marca, Pageable pageable);

    Page<ProdutoModel> findByCategoria(String categoria, Pageable pageable);
}
