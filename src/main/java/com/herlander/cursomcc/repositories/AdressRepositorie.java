package com.herlander.cursomcc.repositories;

import com.herlander.cursomcc.domain.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdressRepositorie extends JpaRepository<Adress, Integer> {

}
