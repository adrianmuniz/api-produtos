package com.testeonebrain.apiprodutos.service.impl;

import com.testeonebrain.apiprodutos.dtos.CategoriaDTO;
import com.testeonebrain.apiprodutos.dtos.ProdutoDTO;
import com.testeonebrain.apiprodutos.model.CategoriaModel;
import com.testeonebrain.apiprodutos.model.ProdutoModel;
import com.testeonebrain.apiprodutos.repositories.CategoriaRepository;
import com.testeonebrain.apiprodutos.service.CategoriaService;
import com.testeonebrain.apiprodutos.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public CategoriaModel findById(CategoriaDTO categoriaDTO) {
        return categoriaRepository.findById(categoriaDTO);
    }

    @Override
    public CategoriaDTO save(CategoriaDTO categoriaDTO) {
        var entity = new CategoriaModel();
        copyToEntity(categoriaDTO, entity);
        entity = categoriaRepository.save(entity);
        return new CategoriaDTO(entity);
    }

    @Override
    public CategoriaDTO inativarProduto(Long categoriaId, CategoriaDTO categoriaDTO) {
        try {
            CategoriaModel entity = categoriaRepository.getOne(categoriaId);
            entity.setAtivo(!categoriaDTO.isAtivo());
            entity = categoriaRepository.save(entity);
            return new CategoriaDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id Not Found" + categoriaId);
        }
    }

    @Override
    public CategoriaDTO ativarProduto(Long categoriaId, CategoriaDTO categoriaDTO) {
        try {
            CategoriaModel entity = categoriaRepository.getOne(categoriaId);
            entity.setAtivo(categoriaDTO.isAtivo());
            entity = categoriaRepository.save(entity);
            return new CategoriaDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id Not Found" + categoriaId);
        }
    }

    @Override
    public Page<CategoriaModel> findAll(Pageable pageable) {
        return categoriaRepository.findAll(pageable);
    }

    public void copyToEntity(CategoriaDTO dto, CategoriaModel entity){
        entity.setNome(dto.getNome());
        entity.setAtivo(dto.isAtivo());
    }
}
