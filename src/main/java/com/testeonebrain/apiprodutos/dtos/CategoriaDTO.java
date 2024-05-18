package com.testeonebrain.apiprodutos.dtos;

import com.testeonebrain.apiprodutos.model.CategoriaModel;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;

    private boolean ativo;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaDTO(CategoriaModel entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
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

    public void setNome(String name) {
        this.nome = name;
    }

    public boolean isAtivo() {
        return true;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
