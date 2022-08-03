/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audaz.services.Impl;

import java.util.UUID;
import audaz.models.Operator;
import audaz.models.Fare;
import audaz.services.BaseService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 *
 * @author migue
 */
public class OperatorService extends BaseService<Operator, UUID>{

    @Override
    public Operator insert(Operator entity) throws Exception {
       entity.setId(UUID.randomUUID());
       Boolean jaExiste =  fakeDatabase.stream().anyMatch(x -> x.getId() == entity.getId());
       if(jaExiste)
           throw new Exception("ID já cadastrado!");
       
       fakeDatabase.add(entity);
       
       return entity;
    }
    
    
    
    public Optional<Operator> findByCode(String code){
       return this.findAll().stream().filter(x-> x.getCode().equals(code))
               .findFirst();
    }
    
    public void addFare(Fare fare, String code){
        Operator op = this.findByCode(code).get();
        if(op.getFares() == null)
            op.setFares(new ArrayList<>());
        op.getFares().add(fare);
        fakeDatabase.forEach((x) -> {
            
            if(x.getId() == op.getId() && x.getCode() != null)
                x = op;
        });
        
    }

    @Override
    public List<Operator> list() throws Exception {
        return this.findAll();
    }

    @Override
    public Operator delete(Operator entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Operator update(Operator entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
