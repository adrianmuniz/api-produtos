package com.testeonebrain.apiprodutos.service;

import com.testeonebrain.apiprodutos.dtos.CategoriaDTO;
import com.testeonebrain.apiprodutos.model.CategoriaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoriaService {

    CategoriaModel findById(CategoriaDTO categoriaDTO);

    CategoriaDTO save(CategoriaDTO categoriaDTO);

    CategoriaDTO inativarProduto(Long categoriaId, CategoriaDTO categoriaDTO);

    CategoriaDTO ativarProduto(Long categoriaId, CategoriaDTO categoriaDTO);

    Page<CategoriaModel> findAll(Pageable pageable);
}
