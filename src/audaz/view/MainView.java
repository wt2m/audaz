package audaz.view;

import java.util.Scanner;
import audaz.models.enums.MainViewEnum;

public class MainView {
    
    public MainViewEnum view(){
        Scanner s = new Scanner(System.in);
        MainViewEnum opt;
        
        do{
            System.out.printf(
                        "============================\n"
                    +   "1 - FARE OPTIONS\n"
                    +   "2 - OPERATOR OPTIONS\n"
                    +   "0 - EXIT\n"
                    +   "============================\n"
            );
            
            opt = MainViewEnum.setValue(s.nextInt());
        }while(opt == MainViewEnum.ERROR);
        return opt;
    }
}
