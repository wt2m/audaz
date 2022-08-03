package audaz.view;

import audaz.models.Operator;
import java.util.Scanner;
import audaz.view.BaseView;

public class OperatorView extends BaseView {
    public Operator criar(){
        Scanner s = new Scanner(System.in);
        
        Operator op = new Operator();
        System.out.printf(
                "=============================\n"
                +"     CADASTRAR OPERADORA\n"
                +"=============================\n");
        System.out.print("Informe o código da operadora: ");
        op.setCode(s.next());
        return op;
    }
}
