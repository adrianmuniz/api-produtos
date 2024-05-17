package com.testeonebrain.apiprodutos.service.impl;

import com.testeonebrain.apiprodutos.dtos.CategoriaDTO;
import com.testeonebrain.apiprodutos.model.CategoriaModel;
import com.testeonebrain.apiprodutos.repositories.CategoriaRepository;
import com.testeonebrain.apiprodutos.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public CategoriaModel findById(CategoriaDTO categoriaDTO) {
        return categoriaRepository.findById(categoriaDTO);
    }
}
