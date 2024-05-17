package com.testeonebrain.apiprodutos.dtos;

import com.testeonebrain.apiprodutos.model.CategoriaModel;
import com.testeonebrain.apiprodutos.model.ProdutoModel;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private String descricao;

    private String marca;

    private Double preco;

    private String categorias;

    public ProdutoDTO() {

    }

    public ProdutoDTO(Long id, String nome, String descricao, String marca, Double preco, String categorias) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.marca = marca;
        this.preco = preco;
        this.categorias = categorias;
    }

    public ProdutoDTO(ProdutoModel entity) {
        this.id = entity.getProdutoId();
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
        this.preco = entity.getPreco();
        this.marca = entity.getMarca();
        this.categorias = entity.getCategorias();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }
}
