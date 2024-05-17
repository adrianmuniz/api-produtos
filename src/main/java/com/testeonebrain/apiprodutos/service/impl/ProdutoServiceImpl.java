package com.testeonebrain.apiprodutos.service.impl;

import com.testeonebrain.apiprodutos.dtos.CategoriaDTO;
import com.testeonebrain.apiprodutos.dtos.ProdutoDTO;
import com.testeonebrain.apiprodutos.model.CategoriaModel;
import com.testeonebrain.apiprodutos.model.ProdutoModel;
import com.testeonebrain.apiprodutos.repositories.CategoriaRepository;
import com.testeonebrain.apiprodutos.repositories.ProdutoRepository;
import com.testeonebrain.apiprodutos.service.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        var entity = new ProdutoModel();
        copyToEntity(produtoDTO, entity);
        entity = produtoRepository.save(entity);
        return new ProdutoDTO(entity);
    }

    @Override
    public Page<ProdutoModel> findAll(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    @Override
    public Optional<ProdutoModel> findById(Long produtoId) {
        return produtoRepository.findById(produtoId);
    }

    public void copyToEntity(ProdutoDTO dto, ProdutoModel entity){
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setPreco(dto.getPreco());
        entity.setMarca(dto.getMarca());

        entity.getCategorias().clear();
        for (CategoriaDTO catDto : dto.getCategorias()) {
            CategoriaModel categoria = categoriaRepository.getOne(catDto.getId());
            entity.getCategorias().add(categoria);
        }
    }
}
