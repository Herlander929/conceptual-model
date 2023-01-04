package com.herlander.cursomcc.repositories;

import com.herlander.cursomcc.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepositorie extends JpaRepository<Client, Integer> {

}
