package com.herlander.cursomcc.repositories;

import com.herlander.cursomcc.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PedidoRepositorie extends JpaRepository<Pedido, Integer> {

}
