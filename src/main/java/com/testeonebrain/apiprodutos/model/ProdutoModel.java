package com.testeonebrain.apiprodutos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_PRODUTOS")
public class ProdutoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 150)
    private String descricao;

    @Column(nullable = false)
    private String marca;

    private Double preco;

    @ManyToMany
    @JoinTable(name = "tb_produtos_categorias",
                        joinColumns = @JoinColumn(name = "product_id"),
                        inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    Set<CategoriaModel> categorias = new HashSet<>();

}
