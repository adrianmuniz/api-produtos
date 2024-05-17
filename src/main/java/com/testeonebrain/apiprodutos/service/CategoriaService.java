package com.testeonebrain.apiprodutos.service;

import com.testeonebrain.apiprodutos.dtos.CategoriaDTO;
import com.testeonebrain.apiprodutos.model.CategoriaModel;

public interface CategoriaService {

    CategoriaModel findById(CategoriaDTO categoriaDTO);
}
