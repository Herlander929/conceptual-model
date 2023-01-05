package com.herlander.cursomcc.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.herlander.cursomcc.domain.enums.TipoCliente;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String cpfOuCnpj;
    private Integer type;


    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();


    @JsonManagedReference
    @OneToMany(mappedBy = "client")
    private List<Adress> adresses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "phone")
    private Set<String> phones = new HashSet<>();

    public Client(){}

    public Client(Integer id, String name, String email, String cpfOuCnpj, TipoCliente type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.type = type.getCod();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public TipoCliente getType() {
        return TipoCliente.toEnum(type);
    }

    public void setType(TipoCliente type) {
        this.type = type.getCod();
    }

    public List<Adress> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adress> adresses) {
        this.adresses = adresses;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return id != null ? id.equals(client.id) : client.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
