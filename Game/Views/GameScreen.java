package Game.Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.JGameDisplay;
import Game.Model;
import Game.Controllers.ShipController;
import Game.Util.GameConstants;

public class GameScreen extends JPanel {
    // variables
    private Model model;
    private JGameDisplay display;
    private JLabel time;
    private JLabel roundNum;

    // constructor
    public GameScreen(Model m) {
        model = m;

        display = new JGameDisplay(model, GameConstants.DISPLAY_WIDTH, GameConstants.DISPLAY_HEIGHT);
        time = new JLabel();

        this.layoutView();
        this.registerControllers();
        this.update();
    }

    // adds components to itself
    private void layoutView() {
        display.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));

        this.setLayout(new BorderLayout());
        this.add(time, BorderLayout.NORTH);
        this.add(display, BorderLayout.CENTER);
    }// layoutView

    // sets up controllers for button
    private void registerControllers() {
        display.addKeyListener(new ShipController(model.getShip()));
    }

    // updates gui
    public void update() {
        repaint();
        time.setText(Double.toString(model.getDeltaT()));
        model.getShip().printInfo();
    }
}