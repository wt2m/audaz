/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audaz.controller;

import audaz.models.Fare;
import audaz.models.Operator;
import audaz.models.enums.CrudEnum;
import audaz.services.Impl.FareService;
import audaz.services.Impl.OperatorService;
import audaz.view.OperatorView;
import java.time.LocalDateTime;
import java.util.Optional;
import javafx.util.Pair;

/**
 *
 * @author migue
 */
public class OperatorController {
    private OperatorView screen = new OperatorView(); 
    private OperatorService operatorService;
    private FareService fareService;

    public OperatorController(OperatorService operatorService, FareService fareService) {
        this.operatorService = operatorService;
        this.fareService = fareService;
    }

   
    
    
    public void start() throws Exception{
        CrudEnum opt;
        do{
            opt = screen.crudView("OPERATOR");
            switch(opt)
            {
                case CREATE:
                    this.Create();
                    break;
                case UPDATE:
                    this.operatorService.update(new Operator());
                    break;
                case DELETE:
                    this.operatorService.delete(new Operator());
                    break;
                case LIST:
                    screen.cabecalhoLista();
                    this.operatorService.list().forEach(
                        x -> {
                            this.screen.message(x.toString());
                        }); 
                    this.screen.pressKeyContinue();
                    break;
                default:
                    break;
            }
        }while(opt != CrudEnum.EXIT);
    }
    
    public Operator Create() throws Exception{
        Operator data = screen.criar();
        
        
        data = this.operatorService.insert(data);

        
        return data;
    }
}
