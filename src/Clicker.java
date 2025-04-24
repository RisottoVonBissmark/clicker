import listener.ClickerButtonListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

public class Clicker extends JFrame {
    private int score;
    private double scoreIncrements;
    private int upgradePrice;
    private int usinePrice;

    private ArrayList<Usine> usines; 

    private JPanel scoreFrame;
    private JPanel clickerFrame;
    private JPanel usineFrame;
    
    private JScrollPane usineScrollPane;
    private JPanel innerUsineFrame;

    private JButton clickerButton;
    private JButton upgradeButton;
    private JButton buyUsineButton;

    private JLabel scoreLabel;

    public Clicker() {
        this.setLayout(new GridBagLayout());

        this.score = 0;
        this.scoreIncrements = 1;
        this.upgradePrice = 15;
        this.usinePrice = 100;

        this.usines = new ArrayList<>();

        this.initView();
        
        new Thread(this::main).start();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void main() {
        System.out.println("thread started");
        while (true) {
            
            System.out.print("");   //black magic
            
            for (int i = 0; i  < this.usines.size(); i++) {
                this.score += usines.get(i).product();
                this.scoreLabel.setText(this.score + "");

                if (this.usines.get(i).isWaitingUpgrade()) {
                    this.upgradeUsine(this.usines.get(i));
                }
            }
        }
    }

    private void initView() {

        this.scoreFrame = new JPanel();
        
        this.scoreLabel = new JLabel();
        this.scoreFrame.add(this.scoreLabel);

        this.clickerFrame = new JPanel();
        this.clickerFrame.setLayout(new BoxLayout(this.clickerFrame, BoxLayout.Y_AXIS));

        this.clickerButton = new JButton();
        this.clickerButton.addActionListener(new ClickerButtonListener<>(this::incrementScore));
        this.clickerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.upgradeButton = new JButton();
        this.upgradeButton.addActionListener(new ClickerButtonListener<>(this::upgrade));
        this.upgradeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.clickerFrame.add(this.clickerButton);
        this.clickerFrame.add(this.upgradeButton);
        
        this.usineFrame = new JPanel();
        this.usineFrame.setLayout(new BoxLayout(this.usineFrame, BoxLayout.Y_AXIS));

        this.innerUsineFrame = new JPanel();
        this.innerUsineFrame.setLayout(new BoxLayout(this.innerUsineFrame, BoxLayout.Y_AXIS));

        this.usineScrollPane = new JScrollPane(innerUsineFrame);
        this.usineScrollPane.setPreferredSize(new Dimension(200, 200));

        this.buyUsineButton = new JButton();
        this.buyUsineButton.addActionListener(new ClickerButtonListener<>(this::buyUsine));
        this.buyUsineButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.usineFrame.add(this.buyUsineButton);
        this.usineFrame.add(this.usineScrollPane);

        GridBagConstraints c = new GridBagConstraints();

        c.gridy = 0;
        c.gridx = 0;

        c.gridheight = 3;
        c.gridwidth = 3;

        this.add(this.scoreFrame, c);

        c.gridy = 4;
        c.gridx = 0;

        c.gridheight = 1;
        c.gridwidth = 1;

        this.add(this.clickerFrame, c);

        c.gridy = 4;
        c.gridx = 1;

        c.gridwidth = 1;
        c.gridheight = 1;

        this.add(this.usineFrame, c);

        this.updateLabels();
    }

    private void updateLabels() {
        this.upgradeButton.setText(this.upgradePrice + "");
        this.clickerButton.setText(this.scoreIncrements + "");
        this.scoreLabel.setText(this.score + "");
        this.buyUsineButton.setText(this.usinePrice + "");
    }

    public int incrementScore() {
        this.score += this.scoreIncrements;
        
        this.updateLabels();
        return 0;
    }

    public int upgrade() {
        
        if (! buy(this.upgradePrice)) {
            return -1;
        }

        this.scoreIncrements += 0.5 * this.scoreIncrements; 
        this.upgradePrice *= 2;

        this.updateLabels();
        return 0;
    }

    public int buyUsine() {
        
        if (! buy(this.usinePrice)) {
            return -1;
        }
        
        Usine usine = new Usine();
        usines.add(usine);
        innerUsineFrame.add(usine.getPanel());
        
        this.updateLabels();
        return 0;
    }

    public int upgradeUsine(Usine usine) {
        usine.setWaitingUpgrade(false);

        if (! buy(usine.getUpgradePrice())) {
            return -1;
        }

        usine.upgrade();

        return 0;
    }

    public boolean buy(int amount) {
        if (this.score >= amount) {
            this.score -= amount;
            return true;
        }
        return false;
    }
}
