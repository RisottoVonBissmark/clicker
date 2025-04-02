import controller.ClickerController;
import controller.FactoryController;
import model.ClickerModel;
import model.FactoryModel;
import vue.ClickerView;

public class Main {
    
    public static void main(String[] args) {
        
        ClickerModel model = new ClickerModel();
        ClickerController controller = new ClickerController(model);

        FactoryModel factoryModel = new FactoryModel();
        FactoryController factoryController = new FactoryController(factoryModel);

        ClickerView vue = new ClickerView(controller);

        model.addObservateur(vue);
        factoryController.addObservateur(controller);

        Thread t1 = new Thread(factoryController);
        t1.start();
    }

}
