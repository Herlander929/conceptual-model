package com.herlander.cursomcc.resources;




import com.herlander.cursomcc.domain.Categories;
import com.herlander.cursomcc.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping(value = "/categorias")
public class Categresource {

    @Autowired
    private CategorieService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categories> find(@PathVariable Integer id){
        Categories obj = service.find(id);
        return ResponseEntity.ok().body(obj);


    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Categories obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();

        return  ResponseEntity.created(uri).build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public  ResponseEntity<Void> update(@RequestBody Categories obj, @PathVariable Integer id) {
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();

    }
}
