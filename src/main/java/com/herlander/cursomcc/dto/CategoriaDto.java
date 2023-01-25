package com.herlander.cursomcc.dto;

import com.herlander.cursomcc.domain.Categories;

import java.io.Serializable;

public class CategoriaDto implements Serializable {

    private Integer id;
    private String nome;

    public  CategoriaDto(){

    }

    public  CategoriaDto(Categories obj){
        id = obj.getId();
        nome = obj.getNome();
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
}
