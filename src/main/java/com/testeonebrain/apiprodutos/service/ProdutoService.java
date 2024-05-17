package com.testeonebrain.apiprodutos.service;

import com.testeonebrain.apiprodutos.dtos.ProdutoDTO;
import com.testeonebrain.apiprodutos.model.ProdutoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoService {
    ProdutoDTO save(ProdutoDTO produtoDTO);

    Page<ProdutoModel> findAll(Pageable pageable);
}
