package com.testeonebrain.apiprodutos.dtos;

import com.testeonebrain.apiprodutos.model.CategoriaModel;
import com.testeonebrain.apiprodutos.model.ProdutoModel;

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

    private boolean ativo;

    private List<CategoriaDTO> categorias  = new ArrayList<>();

    public ProdutoDTO() {

    }

    public ProdutoDTO(Long id, String nome, String descricao, String marca, Double preco, boolean ativo, List<CategoriaDTO> categorias) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.marca = marca;
        this.preco = preco;
        this.ativo = ativo;
        this.categorias = categorias;
    }

    public ProdutoDTO(ProdutoModel entity) {
        this.id = entity.getProdutoId();
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
        this.preco = entity.getPreco();
        this.marca = entity.getMarca();
    }

    public ProdutoDTO(ProdutoModel entity, Set<CategoriaModel> categorias) {
        this(entity);
        categorias.forEach(cat -> this.categorias.add(new CategoriaDTO(cat)));
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

    public List<CategoriaDTO> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaDTO> categories) {
        this.categorias = categories;
    }

    public boolean isAtivo() {
        return true;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
