package com.herlander.cursomcc.resources;




import com.herlander.cursomcc.domain.Categories;
import com.herlander.cursomcc.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping(value = "/categorias")
public class Categresource {

    @Autowired
    private CategorieService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){
        Categories obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);


    }
}
