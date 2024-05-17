package com.testeonebrain.apiprodutos.service.impl;

import com.testeonebrain.apiprodutos.dtos.CategoriaDTO;
import com.testeonebrain.apiprodutos.dtos.ProdutoDTO;
import com.testeonebrain.apiprodutos.model.CategoriaModel;
import com.testeonebrain.apiprodutos.model.ProdutoModel;
import com.testeonebrain.apiprodutos.repositories.CategoriaRepository;
import com.testeonebrain.apiprodutos.repositories.ProdutoRepository;
import com.testeonebrain.apiprodutos.service.ProdutoService;
import com.testeonebrain.apiprodutos.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public ProdutoModel save(ProdutoModel produtoModel) {

        return produtoRepository.save(produtoModel);
    }

    @Override
    public Page<ProdutoModel> findAll(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    @Override
    public Optional<ProdutoModel> findById(Long produtoId) {
        return produtoRepository.findById(produtoId);
    }

    @Override
    public ProdutoDTO update(Long productId, ProdutoDTO productDto) {
        try {
            ProdutoModel entity = produtoRepository.getOne(productId);
            copyToEntity(productDto, entity);
            entity = produtoRepository.save(entity);
            return new ProdutoDTO(entity);
        } catch (EntityNotFoundException e) {
                throw new ResourceNotFoundException("Id Not Found" + productId);
        }
    }

    @Override
    public void delete(ProdutoModel produtoModel) {
        produtoRepository.delete(produtoModel);
    }

    @Override
    public Page<ProdutoModel> findByMarca(String marca, Pageable pageable) {

        return produtoRepository.findByMarca(marca, pageable);
    }

    @Override
    public Page<ProdutoModel> findByCategoria(String categoria, Pageable pageable) {
        return produtoRepository.findByCategoria(categoria, pageable);
    }

    public void copyToEntity(ProdutoDTO dto, ProdutoModel entity){
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setPreco(dto.getPreco());
        entity.setMarca(dto.getMarca());
        entity.setCategorias(dto.getCategorias());
    }
}
