package com.herlander.cursomcc.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Categories implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;




    @ManyToMany(mappedBy = "categorias")
    private List<Products> produtos = new ArrayList<>();

    public List<Products> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Products> produtos) {
        this.produtos = produtos;
    }

    public Categories() {

    }

    public Categories(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categories)) return false;

        Categories categories = (Categories) o;

        return Objects.equals(id, categories.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
