/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task5animation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.security.Key;

import kg2019examples_task5animation.math.Vector2;
import kg2019examples_task5animation.model.*;
import kg2019examples_task5animation.model.usersModels.CircleModel;
import kg2019examples_task5animation.model.usersModels.Model;
import kg2019examples_task5animation.model.usersModels.TextModel;
import kg2019examples_task5animation.timers.AbstractWorldTimer;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.xml.crypto.dsig.keyinfo.KeyName;

import kg2019examples_task5animation.math.Rectangle;
import kg2019examples_task5animation.timers.UpdateWorldTimer;
import kg2019examples_task5animation.utils2d.ScreenConverter;
import kg2019examples_task5animation.utils2d.ScreenPoint;

/**
 *
 * @author Alexey
 */
public class DrawPanel extends JPanel implements ActionListener,
        //MouseListener, MouseMotionListener, MouseWheelListener,
        KeyListener {
    private ScreenConverter sc;
    private World w;
    private AbstractWorldTimer uwt;
    private Timer drawTimer;
    private Model m;
    private Model m2;

    public DrawPanel() {
        super();
        Field f = new Field(
                new Rectangle(0, 10, 10, 10),
            0.1, 9.8);
       // w = new World(new TextModel(f.getRectangle().getCenter(), 1, "Hello World"), f);
        //w = new World(new CircleModel(f.getRectangle().getCenter(), 1, 0.3), f);
        m = new CircleModel(f.getRectangle().getCenter(), 1, 0.3);
        m2 = new CircleModel(f.getRectangle().getCenter(), 1, 0.3);
        w = new World(m, m2, f);
        sc = new ScreenConverter(f.getRectangle(), 450, 450);
        //this.addMouseListener(this);
        //this.addMouseMotionListener(this);
        //this.addMouseWheelListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();
        
        (uwt = new UpdateWorldTimer(w, 10)).start();
        drawTimer = new Timer(40, this);
        drawTimer.start();

    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        w.draw((Graphics2D)bi.getGraphics(), sc);
        g.drawImage(bi, 0, 0, null);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public World getW() {
        return w;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                w.getExternalForce().setLocation(new Vector2(m.getPosition().getX(), m.getPosition().getY()+1));
                w.getExternalForce().setValue(10);
                break;
            case KeyEvent.VK_S:
                w.getExternalForce().setLocation(new Vector2(m.getPosition().getX(), m.getPosition().getY()-1));
                w.getExternalForce().setValue(10);
                break;
            case KeyEvent.VK_A:
                w.getExternalForce().setLocation(new Vector2(m.getPosition().getX()-1, m.getPosition().getY()));
                w.getExternalForce().setValue(10);
                break;
            case KeyEvent.VK_D:
                w.getExternalForce().setLocation(new Vector2(m.getPosition().getX()+1, m.getPosition().getY()));
                w.getExternalForce().setValue(10);
                break;
            case KeyEvent.VK_UP:
                w.getExternalForce2().setLocation(new Vector2(m2.getPosition().getX(), m2.getPosition().getY()+1));
                w.getExternalForce2().setValue(10);
                break;
            case KeyEvent.VK_DOWN:
                w.getExternalForce2().setLocation(new Vector2(m2.getPosition().getX(), m2.getPosition().getY()-1));
                w.getExternalForce2().setValue(10);
                break;
            case KeyEvent.VK_LEFT:
                w.getExternalForce2().setLocation(new Vector2(m2.getPosition().getX()-1, m2.getPosition().getY()));
                w.getExternalForce2().setValue(10);
                break;
            case KeyEvent.VK_RIGHT:
                w.getExternalForce2().setLocation(new Vector2(m2.getPosition().getX()+1, m2.getPosition().getY()));
                w.getExternalForce2().setValue(10);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        w.getExternalForce().setValue(0);
        w.getExternalForce2().setValue(0);
    }
}
