package com.herlander.cursomcc.services;

import com.herlander.cursomcc.domain.Client;
import com.herlander.cursomcc.exceptions.ObjectNotFoundException;
import com.herlander.cursomcc.repositories.CategorieRepositorie;
import com.herlander.cursomcc.repositories.ClientRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepositorie repo;

    public Client buscar(Integer id) {
        Optional<Client> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()));

    }
}
