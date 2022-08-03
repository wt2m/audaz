package audaz.controller;

import audaz.view.MainView;
import audaz.models.enums.MainViewEnum;
import audaz.services.Impl.FareService;
import audaz.services.Impl.OperatorService;

public class MainController {
    private MainView view = new MainView();
    private OperatorController operatorController;
    private FareController fareController;
    private OperatorService operatorService = new OperatorService();
    private FareService fareService = new FareService();

    public MainController() {
        this.operatorController = new OperatorController(this.operatorService, this.fareService);
        this.fareController = new FareController(this.operatorService, this.fareService);
    }
    
    public void start() throws Exception{
        MainViewEnum opt;
        do {
            opt = view.view();
            switch(opt)
            {
                case FARE:
                    this.fareController.start();
                    break;
                case OPERATOR:
                    this.operatorController.start();
                    break;
                default:
                    break;
            }
            System.out.flush();
        } while (opt != MainViewEnum.EXIT);
        
        System.out.println("Finalizando...");
    }
    
}
