package Game;

/*  JGameDisplay
 *  Andy Dai
 *  June 12 2023
 *  Custom JComponent that draws the ship, meteors and background
 */

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Game.GameObjects.ColliderObject;
import Game.GameObjects.Meteor;
import Game.GameObjects.Ship;
import Game.Util.Vector2D;

public class JGameDisplay extends JComponent {
    private Model model;
    private Ship ship;
    private BufferedImage background;

    // constructor
    public JGameDisplay(Model m, int w, int h) {
        super();
        model = m;
        ship = model.getShip();

        // get background image
        try {
            background = ImageIO.read(new File("Game/Sprites/background.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.setPreferredSize(new Dimension(w, h));
    }

    // paint background, ship and meteors
    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        g.drawImage(background, 0, 0, null);
        drawObject(g, ship);
        drawMeteors(g);
    }

    // draws meteors
    private void drawMeteors(Graphics g) {
        for (Meteor meteor : model.getMeteors()) {
            drawObject(g, meteor);
        } // for
    }

    // draws the icon of a collider object
    private void drawObject(Graphics g, ColliderObject object) {
        Vector2D cornerPos = posToCorner(object.getPosition(), object.getIconSize());
        g.drawImage(object.getIcon(), (int) cornerPos.getX(), (int) cornerPos.getY(), null);
    }

    // translates center point to top left corner
    private Vector2D posToCorner(Vector2D pos, int[] size) {
        return new Vector2D(pos.getX() - size[0] / 2, pos.getY() - size[1] / 2);
    }
}// class
