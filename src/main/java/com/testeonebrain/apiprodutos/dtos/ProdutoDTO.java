package com.testeonebrain.apiprodutos.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private String descricao;

    private String marca;

    private Double preco;

    private List<CategoriaDTO> categorias = new ArrayList<>();
}
