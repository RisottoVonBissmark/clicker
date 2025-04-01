package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ClickerController;
import observer.Observateur;

public class ClickerView extends JFrame implements Observateur{
    
    private JPanel container;

    private ClickerController controller;

    private JButton clickButton;
    private JButton upgradeButton;
    private JLabel scoreLabel;

    public ClickerView(ClickerController controller) {
        
        this.controller = controller;

        this.setSize(1750, 1000);
        this.setTitle("boutton clicker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.container = new JPanel();

        clickButton = new JButton();
        clickButton.setText("click !");
        clickButton.addActionListener(new ClickButtonListener());

        upgradeButton = new JButton();
        upgradeButton.addActionListener(new UpgradeButtonListener());

        scoreLabel = new JLabel();

        this.container.add(clickButton);
        this.container.add(scoreLabel);
        this.container.add(upgradeButton);
        
        this.setContentPane(container);

        this.setVisible(true);
    }

    public void update(String score, String priceUpgrade) {
        this.scoreLabel.setText(score);
        this.upgradeButton.setText(priceUpgrade);
    }

    public class ClickButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            controller.incrementScore();
        }
    }

    public class UpgradeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            controller.upgrade();
        }
    }
}
