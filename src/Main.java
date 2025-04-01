import controller.ClickerController;
import model.ClickerModel;
import vue.ClickerView;

public class Main {
    
    public static void main(String[] args) {
        
        ClickerModel model = new ClickerModel();
        ClickerController controller = new ClickerController(model);

        ClickerView vue = new ClickerView(controller);

        model.addObservateur(vue);
    }

}
