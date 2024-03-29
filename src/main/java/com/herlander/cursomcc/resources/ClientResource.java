package com.herlander.cursomcc.resources;




import com.herlander.cursomcc.domain.Client;
import com.herlander.cursomcc.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/clientes")
public class ClientResource {

    @Autowired
    private ClientService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> find(@PathVariable Integer id){
        Client obj = service.find(id);
        return ResponseEntity.ok().body(obj);


    }
}
