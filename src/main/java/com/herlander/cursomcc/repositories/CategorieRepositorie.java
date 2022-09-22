package com.herlander.cursomcc.repositories;

import com.herlander.cursomcc.domain.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepositorie extends JpaRepository<Categories, Integer> {

}
