/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AntGame.Game;

/**
 * used as a key in a hashmap of hexagonal cells. 
 * @author tw242
 */
public class Coordinate {
    private int xPos, yPos;
    
    public Coordinate(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Coordinate)) {
            return false;
        } else {
            Coordinate checker = (Coordinate)obj;
            return (this.toString() == null ? checker.toString() == null : this.toString().equals(checker.toString()));          
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.xPos;
        hash = 29 * hash + this.yPos;
        return hash;
    }
    
    public String toString() {
        return xPos + "," + yPos;
    }
}
