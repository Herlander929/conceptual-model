package com.herlander.cursomcc.repositories;

import com.herlander.cursomcc.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemPedidoRepositorie extends JpaRepository<ItemPedido, Integer> {

}
