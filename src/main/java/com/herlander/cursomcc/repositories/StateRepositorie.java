package com.herlander.cursomcc.repositories;

import com.herlander.cursomcc.domain.Categories;
import com.herlander.cursomcc.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StateRepositorie extends JpaRepository<State, Integer> {

}
