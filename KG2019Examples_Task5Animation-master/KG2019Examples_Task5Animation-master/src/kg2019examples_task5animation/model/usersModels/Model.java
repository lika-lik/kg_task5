/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task5animation.model.usersModels;

import kg2019examples_task5animation.math.Vector2;
import kg2019examples_task5animation.utils2d.ScreenConverter;

import java.awt.*;

public abstract class Model {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    //private Drawer drawer;
    private double r;
    private double m;

    public Model(Vector2 position, double r, double m) {
        //this.drawer = d;
        this.r = r;
        this.m = m;
        this.position = position;
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(0, 0);
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector2 acceleration) {
        this.acceleration = acceleration;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    /*public Polygon getPolygon(ScreenConverter sc) {
        return cc.getPolygon(sc, position.getX(), position.getY(), r);
    }

     */
    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public abstract void draw(Graphics2D g, ScreenConverter sc);
    //{
        //drawer.draw(g, sc, position, r);
   // }
}
