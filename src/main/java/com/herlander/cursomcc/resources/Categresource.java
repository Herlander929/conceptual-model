package com.herlander.cursomcc.resources;




import com.herlander.cursomcc.domain.Categories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping(value = "/categorias")
public class Categresource {

    @GetMapping
    public List<Categories> list(){

        Categories cat1 = new Categories(1, "Informática");
        Categories cat2 = new Categories(2, "Escritório");

        List<Categories> lista = new ArrayList<>();
        lista.add(cat1);
        lista.add(cat2);

        return lista;
    }
}
