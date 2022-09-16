package com.herlander.cursomcc.resources;




import com.herlander.cursomcc.domain.Categoriess;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping(value = "/categorias")
public class Categresource {

    @GetMapping
    public List<Categoriess> list(){

        Categoriess cat1 = new Categoriess(1, "Informática");
        Categoriess cat2 = new Categoriess(2, "Escritório");

        List<Categoriess> lista = new ArrayList<>();
        lista.add(cat1);
        lista.add(cat2);

        return lista;
    }
}
