/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task5animation;

import kg2019examples_task5animation.model.Field;
import kg2019examples_task5animation.model.World;
import kg2019examples_task5animation.model.usersModels.CircleModel;
import kg2019examples_task5animation.model.usersModels.TextModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Alexey
 */
public class KG2019Examples_Task5Animation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        JFrame frame = new JFrame();
        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DrawPanel panel = new DrawPanel();
        mainPanel.add(panel);

        /*Panel panel2 = new Panel();
        Panel panel4 = new Panel();
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
        panel4.setMaximumSize(new Dimension(300, 500));
        panel2.setLayout(new FlowLayout());
        Button bText = new Button("Текст");
        Button bCircle = new Button("Круг");
        Button bMouse = new Button("Нарисовать");
        panel2.add(bText);
        panel2.add(bCircle);
        panel2.add(bMouse);
        panel4.add(panel2);
        mainPanel.add(panel4);
        frame.add(mainPanel);
        frame.setVisible(true);

        bCircle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel3 = new JPanel();
                JLabel l = new JLabel("Введите радиус");
                JTextField t = new JTextField("0.1");
                JLabel l2 = new JLabel("Введите массу");
                JTextField t2 = new JTextField("1");
                JButton b = new JButton("Создать");
                panel3.add(l);panel3.add(t);panel3.add(l2);panel3.add(t2);panel3.add(b);
                panel4.add(panel3);
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        World w = panel.getW();
                        Field f = w.getF();
                        w.setM(new CircleModel(f.getRectangle().getCenter(),
                                Double.valueOf(t2.getText()), Double.valueOf(t.getText())));
                    }
                });
            }
        });

        bText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel3 = new JPanel();
                JLabel l = new JLabel("Введите текст");
                JTextField t = new JTextField("Hello World");
                JLabel l2 = new JLabel("Введите массу");
                JTextField t2 = new JTextField("1");
                JButton b = new JButton("Создать");
                panel3.add(l);panel3.add(t);panel3.add(l2);panel3.add(t2);panel3.add(b);
                panel4.add(panel3);
                panel4.repaint();
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        World w = panel.getW();
                        Field f = w.getF();
                        w.setM(new TextModel(f.getRectangle().getCenter(),
                                Double.valueOf(t2.getText()), t.getText()));
                    }
                });
            }
        });

         */
    }
}
