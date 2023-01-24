package com.herlander.cursomcc.services;

import com.herlander.cursomcc.domain.Pedido;
import com.herlander.cursomcc.exceptions.ObjectNotFoundException;
import com.herlander.cursomcc.repositories.PedidoRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepositorie repo;

    public Pedido find(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));

    }
}
