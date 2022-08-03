/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audaz.view;

import audaz.models.enums.CrudEnum;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author migue
 */
abstract class BaseView {
    public void message(String message){
        System.out.printf("\n"+message+"\n");
    }
    
   
    
    public CrudEnum crudView(String modelName){
        
        Scanner s = new Scanner(System.in);
        CrudEnum opt = CrudEnum.EXIT;
        do{
            System.out.printf(
                        "============================\n"
                    +   "            "+modelName+"          \n"
                    +   "============================\n\n"
                    +   "1 - CREATE\n"
                    +   "2 - UPDATE\n"
                    +   "3 - DELETE\n"
                    +   "4 - LIST\n"
                    +   "0 - RETURN\n"
                    +   "============================\n"
            );
            opt = CrudEnum.setValue(s.nextInt());
        } while (opt == CrudEnum.ERROR);
        
        return opt;
        
    }
    
    public void cabecalhoLista(){
        System.err.printf("==========================\n"+"      Listagem\n" + "==========================\n");
    }
    
    public void pressKeyContinue(){
        System.out.println("Press enter to continue");
        try{System.in.read();}
            catch(Exception e){}
    }
}
