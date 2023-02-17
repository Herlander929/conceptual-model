package com.herlander.cursomcc.dto;

import com.herlander.cursomcc.domain.Categories;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

public class CategoriaDto implements Serializable {

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min=5, max=80, message= "O tamanho deve ser entre 5 e 80 caracteres")
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
