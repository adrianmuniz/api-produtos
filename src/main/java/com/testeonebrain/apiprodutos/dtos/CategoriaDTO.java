package com.testeonebrain.apiprodutos.dtos;

import com.testeonebrain.apiprodutos.model.CategoriaModel;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoriaDTO(CategoriaModel entity) {
        this.id = entity.getCategoriaId();
        this.name = entity.getNome();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
