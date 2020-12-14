package kg2019examples_task5animation.model.usersModels;

import kg2019examples_task5animation.math.Vector2;
import kg2019examples_task5animation.utils2d.ScreenConverter;
import kg2019examples_task5animation.utils2d.ScreenPoint;

import java.awt.*;

public class CircleModel extends Model {

    public CircleModel(Vector2 position, double m, double r) {
        super(position, r, m);
    }

    @Override
    public void draw(Graphics2D g, ScreenConverter sc) {
        ScreenPoint pc = sc.r2s(super.getPosition());
        int rh = sc.r2sDistanceH(super.getR());
        int rv = sc.r2sDistanceV(super.getR());
        g.fillOval(pc.getI() - rh, pc.getJ() - rv, rh + rh, rv + rv);
    }


    /* public Polygon getPolygon(ScreenConverter sc, double x0, double y0, double r){
         int size = steps;
         int[] x = new int[size];
         int[] y = new int[size];
         for (int i = 0; i < steps; i++){
             double xReal = x0 + r*Math.cos(2*Math.PI * i / steps);
             double yReal = y0 + r*Math.sin(2*Math.PI * i / steps);
             ScreenPoint pc = sc.r2s(new Vector2(xReal, yReal));
             x[i] = pc.getI();
             y[i] = pc.getJ();
         }
         return new Polygon(x, y, size);
     }

     */
    public void draw(Graphics2D g, ScreenConverter sc, Vector2 position, double r) {
        ScreenPoint pc = sc.r2s(position);
        int rh = sc.r2sDistanceH(r);
        int rv = sc.r2sDistanceV(r);
        g.fillOval(pc.getI() - rh, pc.getJ() - rv, rh + rh, rv + rv);
    }
}
