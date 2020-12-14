package kg2019examples_task5animation.model.usersModels;

import kg2019examples_task5animation.math.Vector2;
import kg2019examples_task5animation.model.usersModels.Model;
import kg2019examples_task5animation.utils2d.ScreenConverter;
import kg2019examples_task5animation.utils2d.ScreenPoint;

import java.awt.*;

public class TextModel extends Model {
    private String string;

    public TextModel(Vector2 position, double m, String string) {
        super(position, 0, m);
        this.string = string;
    }

    public void draw(Graphics2D g, ScreenConverter sc, Vector2 position, double r) {
        ScreenPoint pc = sc.r2s(position);
        //int rh = sc.r2sDistanceH(r);
        //int rv = sc.r2sDistanceV(r);
        //g.drawString(string, pc.getI() - rh, pc.getJ() - rv);
        g.drawString(string, pc.getI(), pc.getJ());
    }

    @Override
    public void draw(Graphics2D g, ScreenConverter sc) {
        ScreenPoint pc = sc.r2s(super.getPosition());
        g.drawString(string, pc.getI(), pc.getJ());
    }
}
