package com.herlander.cursomcc.services;

import com.herlander.cursomcc.domain.Categories;
import com.herlander.cursomcc.exceptions.DataIntegrityException;
import com.herlander.cursomcc.exceptions.ObjectNotFoundException;
import com.herlander.cursomcc.repositories.CategorieRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepositorie repo;

    public Categories find(Integer id) {
        Optional<Categories> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categories.class.getName()));

    }

    public Categories insert(Categories obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public   Categories update(Categories obj){
        find(obj.getId());
        return repo.save(obj);
    }

    public void delete (Integer id) {
        find(id);
        try{
            repo.deleteById(id);

        }catch (DataIntegrityViolationException e) {
                throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
        }

    }
}
