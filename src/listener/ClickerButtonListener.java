package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

public class ClickerButtonListener<T> implements ActionListener {
    
    Callable<T> func;

    public ClickerButtonListener(Callable<T> func) {
        this.func = func;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            this.func.call();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
