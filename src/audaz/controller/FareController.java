package audaz.controller;

import audaz.models.Fare;
import audaz.models.Operator;
import audaz.models.enums.CrudEnum;
import audaz.services.Impl.FareService;
import audaz.services.Impl.OperatorService;
import audaz.view.FareView;
import java.time.LocalDateTime;
import java.util.Optional;
import javafx.util.Pair;


public class FareController {
    private FareView screen = new FareView(); 
    private OperatorService operatorService;
    private FareService fareService;

    public FareController(OperatorService operatorService, FareService fareService) {
        this.operatorService = operatorService;
        this.fareService = fareService;
    }

    
    
    
    public void start() throws Exception{
        CrudEnum opt;
        do{
            opt = screen.crudView("FARE");
            switch(opt)
            {
                case CREATE:
                    this.Create();
                    break;
                case UPDATE:
                    this.fareService.update(new Fare());
                    break;
                case DELETE:
                    this.fareService.delete(new Fare());
                    break;
                case LIST:
                    this.screen.cabecalhoLista();
                    this.fareService.list().forEach(x -> {
                       this.screen.message(x.toString());
                    });
                    this.screen.pressKeyContinue();
                    break;
                default:
                    break;
            }
        }while(opt != CrudEnum.EXIT);
    }
    
    public Fare Create() throws Exception{
        Pair<Fare, String> data = screen.criar();
        Fare fare = data.getKey();
        String code = data.getValue();
        
        Optional<Operator> op = this.operatorService.findByCode(code);
        if(!op.isPresent()){
            screen.message("Não existe operadora com este código.");
            return null;
        }
        if(op.get().getFares() != null && op.get().getFares().size() > 0){
            final double value = fare.getValue();
            Optional<Fare> ativa = op.get().getFares().stream()
                    .filter(x -> x.getStatus() == 1 
                            && x.getUpdatedAt().plusMonths(6).isAfter(LocalDateTime.now())
                            && x.getValue() == value
                            ).findFirst();

            if(ativa.isPresent()){
                screen.message("Já existe tarifa ativa, criada a menos de 6 meses para esta operadora.");
                return null;
            }
        }
        
        fare.setOperator(op.get());
        fare = this.fareService.insert(fare);
        operatorService.addFare(fare, code);
        
        return fare;
    }
}
