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
public interface Cond {

}

class Friend implements Cond {

    public String toString() {
        return "Friend";
    }
}

class Foe implements Cond {

    public String toString() {
        return "Foe";
    }
}

class FriendWithFood implements Cond {

    public String toString() {
        return "FriendWithFood";
    }
}

class FoeWithFood implements Cond {

    public String toString() {
        return "FoeWithFood";
    }
}

class Food implements Cond {

    public String toString() {
        return "Food";
    }
}

class Rock implements Cond {

    public String toString() {
        return "Rock";
    }
}

class Marker implements Cond {
    int marker;
    
    public Marker(int i) {
        marker = i;
    }
    
    public int getMarker() {
        return marker;
    }
    
    public String toString() {
        return "Marker " + marker;
    }
}

class FoeMarker implements Cond {

    public String toString() {
        return "FoeMarker";
    }
}

class Home implements Cond {

    public String toString() {
        return "Home";
    }
}

class FoeHome implements Cond {

    public String toString() {
        return "FoeHome";
    }
}