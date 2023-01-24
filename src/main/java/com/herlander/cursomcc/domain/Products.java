package com.herlander.cursomcc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
public class Products  implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nome;
    Double preco;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "PRODUCT_CATEGORIE",
    joinColumns = @JoinColumn(name = "Product_id"),
    inverseJoinColumns = @JoinColumn(name = "Categorie_id")
    )
    private List<Categories> categorias = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itens = new HashSet<>();


    public Products(){

    }

    public Products(Integer id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    @JsonIgnore
    public List<Pedido> getPedidos(){
        List<Pedido> lista = new ArrayList<>();
        for(ItemPedido x : itens){
            lista.add(x.getPedido());
        }

        return lista;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Categories> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categories> categorias) {
        this.categorias = categorias;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        return Objects.equals(id, products.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
