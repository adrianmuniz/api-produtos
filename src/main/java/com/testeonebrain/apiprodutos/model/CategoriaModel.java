package com.testeonebrain.apiprodutos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_CATEGORIAS")
public class CategoriaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "categorias")
    private Set<ProdutoModel> produtos = new HashSet<>();

    public CategoriaModel() {
    }

    public CategoriaModel(Long id, String name) {
        this.id = id;
        this.nome = name;
    }

    public Long getCategoriaId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
