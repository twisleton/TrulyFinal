/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AntGame;

import AntGame.Game.Coordinate;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 *
 * @author DSGI
 */
public class DrawGrid extends JPanel {

    private static final long serialVersionUID = 1L;
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    public HashMap<Coordinate, Hexagon> hexagons = new HashMap();

    private Font font = new Font("Arial", Font.BOLD, 18);
    FontMetrics metrics;

    public DrawGrid() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Point origin = new Point(WIDTH / 2, HEIGHT / 2);

        g2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
        g2d.setFont(font);
        metrics = g.getFontMetrics();

        //drawCircle(g2d, origin, 380, true, true, 0x4488FF, 0);
        drawHexGridLoop(g2d, origin, 10, 20, 2);
    }

    private void drawHexGridLoop(Graphics g, Point origin, int size, int radius, int padding) {
        double ang30 = Math.toRadians(30);
        double xOff = Math.cos(ang30) * (radius + padding);
        double yOff = Math.sin(ang30) * (radius + padding);
        int half = size / 2;
        Hexagon newHex;

        for (int row = 0; row < size; row++) {
            int cols = size;// - java.lang.Math.abs(row - half);
            if (row % 2 == 0) { // if even do this
                for (int col = 0; col < cols; col++) {
//                    int xLbl = row < half ? col - row : col - half;
//                    int yLbl = row - half;
                    int x = (int) (origin.x + xOff * (col * 2 + 1 - cols));
                    int y = (int) (origin.y + yOff * (row - half) * 3);

                    newHex = drawHex(g, 0, 0, x, y, radius);
                    hexagons.put(new Coordinate(col, row), newHex);
                }
            } else { // if odd draw this
                for (int col = 0; col < cols; col++) { // offset to the left
//                    int xLbl = row < half ? col - row : col - half;
//                    int yLbl = row - half;
                    int x = (int) (origin.x + xOff * (col * 2 + 1 - cols));
                    int y = (int) (origin.y + yOff * (row - half) * 3);

                    newHex = drawHex(g, 0, 0, x-radius, y, radius);
                    hexagons.put(new Coordinate(col, row), newHex);
                }
            }
        }
    }

    public Hexagon drawHex(Graphics g, int posX, int posY, int x, int y, int r) {
        Graphics2D g2d = (Graphics2D) g;

        Hexagon hex = new Hexagon(x, y, r);

        Graphics2D hexCol = hex.draw(g2d, x, y, 0, 0x008844, true);
        //hex.draw(g2d, x, y, 4, 0x000000, false);

        g.setColor(new Color(0xFFFFFF));
        //g.drawString(text, x - w / 2, y + h / 2);
        
        return hex;
    }

    private String coord(int value) {
        return (value > 0 ? "+" : "") + Integer.toString(value);
    }

}
