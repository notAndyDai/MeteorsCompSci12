package Game.Views;

/*  GameScreen
 *  Andy Dai
 *  June 12 2023
 *  Screen that shows when the game is active
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.JGameDisplay;
import Game.Model;
import Game.Controllers.PauseController;
import Game.Controllers.ShipController;
import Game.Util.GameConstants;

public class GameScreen extends JPanel {
    // variables
    private Model model;
    private JGameDisplay display;
    private JLabel info;

    // constructor
    public GameScreen() {
        model = Model.getInstance();

        display = new JGameDisplay(model, GameConstants.DISPLAY_WIDTH, GameConstants.DISPLAY_HEIGHT);

        info = new JLabel();
        info.setPreferredSize(new Dimension(50, 100));
        info.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 25));

        this.layoutView();
        this.registerControllers();
        // this.update();
    }// constructor

    // adds components to itself
    private void layoutView() {
        display.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));

        // add components to screen
        this.setLayout(new BorderLayout());
        this.add(info, BorderLayout.NORTH);
        this.add(display, BorderLayout.CENTER);
    }// layoutView

    // sets up controllers
    private void registerControllers() {
        ShipController shipControl = new ShipController(model.getShip());
        this.addKeyListener(shipControl);

        PauseController pauseControl = new PauseController();
        this.addKeyListener(pauseControl);
    }

    // updates gui
    public void update() {
        display.repaint();
        info.setText(
                String.format("Time: %-6.2f             Round: %-4d            Esc to pause", model.getTimeSurvived(),
                        model.getCurrentRound()));
    }
}// class
