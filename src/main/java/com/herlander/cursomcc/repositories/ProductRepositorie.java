package com.herlander.cursomcc.repositories;

import com.herlander.cursomcc.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepositorie extends JpaRepository<Products, Integer> {

}
