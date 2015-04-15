package AntGame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawPolyPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /**
         * Polygon p = new Polygon(); for (int i = 0; i < 5; i++)
         * p.addPoint((int) (100 + 50 * Math.cos(i * 2 * Math.PI / 5)), (int)
         * (100 + 50 * Math.sin(i * 2 * Math.PI / 5)));
         */
        Hexagon h = new Hexagon(new Point(25,25), 20);
        
        h.draw((Graphics2D)g, 0, 0, 10, 6464, true);
        
        Hexagon i = new Hexagon(new Point(45,25), 20);
        
        h.draw((Graphics2D)g, 0, 0, 10, 5345, true);
    }
}
