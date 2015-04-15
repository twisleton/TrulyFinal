package AntGame.Game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DSGI
 */
public interface LeftRight {

}

class Left implements LeftRight {
    
    public String toString() {
        return "Left";
    }
}

class Right implements LeftRight {
    
    public String toString() {
        return "Right";
    }
}