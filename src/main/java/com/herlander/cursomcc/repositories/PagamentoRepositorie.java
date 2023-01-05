package com.herlander.cursomcc.repositories;

import com.herlander.cursomcc.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PagamentoRepositorie extends JpaRepository<Pagamento, Integer> {

}
