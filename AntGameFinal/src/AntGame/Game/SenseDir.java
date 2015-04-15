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
public interface SenseDir {
    
}

class Here implements SenseDir {
    
    public String toString() {
        return "Here";
    }
}

class Ahead implements SenseDir {
    
    public String toString() {
        return "Ahead";
    }
}

class LeftAhead implements SenseDir {
    
    public String toString() {
        return "LeftAhead";
    }
}

class RightAhead implements SenseDir {
    
    public String toString() {
        return "RightAhead";
    }
}