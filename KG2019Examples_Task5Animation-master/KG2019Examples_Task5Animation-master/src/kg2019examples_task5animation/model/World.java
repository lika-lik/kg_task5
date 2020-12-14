/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task5animation.model;

import java.awt.Color;
import java.awt.Graphics2D;
import kg2019examples_task5animation.math.Vector2;
import kg2019examples_task5animation.model.usersModels.Model;
import kg2019examples_task5animation.utils2d.ScreenConverter;
import kg2019examples_task5animation.utils2d.ScreenPoint;

/**
 *
 * Класс, описывающий весь мир, в целом.
 * @author Alexey
 */
public class World {
    private Model m;
    private Model m2;
    private Field f;
    private ForceSource externalForce;
    private ForceSource externalForce2;

    public World(Model m, Model m2, Field f) {
        this.m = m;
        this.f = f;
        this.m2 = m2;
        this.externalForce = new ForceSource(f.getRectangle().getCenter());
        this.externalForce2 = new ForceSource(f.getRectangle().getCenter());
    }
    
    /**
     * Метод обновления состояния мира за указанное время
     * @param dt Промежуток времени, за который требуется обновить мир.
     */
    public void update(double dt) {
        update(m, externalForce, dt);
        update(m2, externalForce2, dt);
    }

    private void update(Model m, ForceSource fs, double dt){
        Vector2 np = m.getPosition()
                .add(m.getVelocity().mul(dt))
                .add(m.getAcceleration().mul(dt * dt * 0.5));
        Vector2 nv = m.getVelocity()
                .add(m.getAcceleration().mul(dt));

        double vx = nv.getX(), vy = nv.getY();
        boolean reset = false;
        if (np.getX() - m.getR() < f.getRectangle().getLeft() || np.getX() + m.getR() > f.getRectangle().getRight()) {
            vx = -vx;
            reset = true;
        }
        if (np.getY() - m.getR() < f.getRectangle().getBottom() || np.getY() + m.getR() > f.getRectangle().getTop()) {
            vy = -vy;
            reset = true;
        }
        nv = new Vector2(vx, vy);
        if (nv.length() < 1e-10)
            nv = new Vector2(0, 0);
        if (reset)
            np = m.getPosition();

        Vector2 Fvn = fs.getForceAt(np);
        Vector2 Ftr = m.getVelocity().normolized().mul(-f.getMu() * m.getM() * f.getG());
        Vector2 F = Ftr.add(Fvn);

        m.setAcceleration(F.mul(1 / m.getM()));
        m.setVelocity(nv);
        m.setPosition(np);
    }
    
    /**
     * Метод рисует ткущее состояние мира.
     * На самом деле всю логику рисования стоит вынести из этого класса
     * куда-нибудь в WroldDrawer, унаследованный от IDrawer
     * @param g Графикс, на котором надо нарисовать текущее состояние.
     * @param sc Актуальный конвертер координат.
     */
    public void draw(Graphics2D g, ScreenConverter sc) {
        ScreenPoint tl = sc.r2s(f.getRectangle().getTopLeft());
        int w = sc.r2sDistanceH(f.getRectangle().getWidth());
        int h = sc.r2sDistanceV(f.getRectangle().getHeight());
        g.setColor(Color.WHITE);
        g.fillRect(tl.getI(), tl.getJ(), w, h);
        g.setColor(Color.RED);
        g.drawRect(tl.getI(), tl.getJ(), w, h);
        g.setColor(Color.BLACK);
        m.draw(g, sc);
        m2.draw(g, sc);
        g.drawString(String.format("Mu=%.2f", f.getMu()), 10, 30);
        g.drawString(String.format("F=%.0f", externalForce.getValue()), 10, 50);
    }

    public Field getF() {
        return f;
    }

    public void setF(Field f) {
        this.f = f;
    }
    
    public ForceSource getExternalForce() {
        return externalForce;
    }

    public void setM(Model m) {
        this.m = m;
    }


    public Model getM() {
        return m;
    }

    public ForceSource getExternalForce2() {
        return externalForce2;
    }
}
