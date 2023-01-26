package com.herlander.cursomcc.resources;




import com.herlander.cursomcc.domain.Categories;
import com.herlander.cursomcc.dto.CategoriaDto;
import com.herlander.cursomcc.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDto>> findAll(){
        List<Categories> list = service.findAll();
        List<CategoriaDto> listDto = list.stream().map(obj -> new CategoriaDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);


    }

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public ResponseEntity<Page<CategoriaDto>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome")String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC")String direction){
        Page<Categories> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<CategoriaDto> listDto = list.map(obj -> new CategoriaDto(obj));
        return ResponseEntity.ok().body(listDto);


    }

}
