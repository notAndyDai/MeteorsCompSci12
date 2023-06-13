package Game.Controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Game.Model;
import Game.View.Screens;

public class PauseController implements KeyListener {

    private Model model;

    public PauseController() {
        model = Model.getInstance();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (model.getCurrentScreen() == Screens.GAME) {
                model.pauseGame();
            } else if (model.getCurrentScreen() == Screens.PAUSE) {
                model.resumeGame();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
