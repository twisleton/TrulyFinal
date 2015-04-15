/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AntGame.drawing;

import java.awt.*;
import javax.swing.JPanel;

/**
 *
 * @author tw242
 */
public class DrawingPanel extends JPanel{

    final static Color COLOURBACK = Color.WHITE;
    final static Color COLOURROCKY = new Color(102, 51, 0);
    final static Color COLOURBLACK = new Color(51, 51, 51);
    final static Color COLOURRED = new Color(225, 102, 102);
    final static Color COLOURCLEAR = new Color(214, 214, 214);

    public DrawingPanel() {
        setBackground(COLOURBACK);  
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        
    }
}
