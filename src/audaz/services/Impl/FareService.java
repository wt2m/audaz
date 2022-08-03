/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audaz.services.Impl;

import java.util.UUID;
import audaz.models.Fare;
import audaz.services.BaseService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author migue
 */
public class FareService extends BaseService<Fare, UUID>{

    @Override
    public Fare insert(Fare entity) throws Exception {
       entity.setId(UUID.randomUUID());
       entity.setUpdatedAt(LocalDateTime.now());
       Boolean jaExiste =  fakeDatabase.stream().anyMatch(x -> x.getId() == entity.getId());
       if(jaExiste)
           throw new Exception("ID já cadastrado!");
       
       fakeDatabase.add(entity);
       
       return entity;
    }

    @Override
    public List<Fare> list() throws Exception {
        return this.findAll();
    }

    @Override
    public Fare delete(Fare entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Fare update(Fare entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
