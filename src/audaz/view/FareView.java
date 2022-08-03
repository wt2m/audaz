package audaz.view;

import audaz.models.Fare;
import java.util.Scanner;
import javafx.util.Pair;

public class FareView extends BaseView {
    
    
    
    public Pair<Fare, String> criar(){
        Scanner s = new Scanner(System.in);
        Fare fare = new Fare();
        
        System.out.printf(
                    "============================\n"
                +   "       CADASTRAR FARE\n"
                +   "============================\n"
        );
        System.out.print("Valor da tarifa: ");
        fare.setValue(s.nextFloat());
        
        System.out.print("Status da tarifa: ");
        fare.setStatus(s.nextInt());
        
        System.out.print("Código da operadora: ");
        String codigo = s.next();
        
        return new Pair<>(fare, codigo);
    }
}
