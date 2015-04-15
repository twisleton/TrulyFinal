/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AntGame.Game;

import AntGame.TeamColour;

/**
 *
 * @author tw242
 */
public interface Cell {

    public void setAntPresent(boolean present);

    public boolean getAntPresent();

    public void updateFood(int changeAmount);

    public int getFood();

    public void setMarkerOn(int marker, TeamColour colour);

    public void setMarkerOff(int marker, TeamColour colour);
    
    public void setAntId(int id);
    
    public int getAntId();
    
    public int[] getRedMarkers();
    
    public int[] getBlackMarkers();
}

class ClearCell implements Cell {

    Integer food = 0;
    boolean antPresent = false;
    public int antId = -1; // -1 means no ant
    int[] redMarkers = {0, 0, 0, 0, 0, 0};
    int[] blackMarkers = {0, 0, 0, 0, 0, 0};

    public ClearCell() {
    }

    public ClearCell(int f) {
        food = f;
    }

    @Override
    public String toString() {
        if (food == 0) {
            return ".";
        } else {
            return food.toString();
        }
    }

    @Override
    public void setAntPresent(boolean present) {
        antPresent = present;
    }

    @Override
    public boolean getAntPresent() {
        return antId >= 0;
    }

    @Override
    public void updateFood(int changeAmount) {
        food += changeAmount;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public void setMarkerOn(int marker, TeamColour colour) {
        if (colour.equals(colour.RED)) {
            redMarkers[marker] = 1;
        } else {
            blackMarkers[marker] = 1;
        }
    }

    @Override
    public void setMarkerOff(int marker, TeamColour colour) {
        if (colour.equals(colour.RED)) {
            redMarkers[marker] = 0;
        } else {
            blackMarkers[marker] = 0;
        }
    }

    @Override
    public void setAntId(int id) {
        antId = id;
    }

    @Override
    public int getAntId() {
        return antId;
    }

    @Override
    public int[] getRedMarkers() {
        return redMarkers;
    }

    @Override
    public int[] getBlackMarkers() {
        return blackMarkers;
    }
}

class RockyCell implements Cell {

    boolean antPresent = false;
    int[] redMarkers = {0, 0, 0, 0, 0, 0};
    int[] blackMarkers = {0, 0, 0, 0, 0, 0};

    public RockyCell() {
    }

    @Override
    public String toString() {
        return "#";
    }

    public void setAntPresent(boolean present) {
        antPresent = present;
    }

    @Override
    public boolean getAntPresent() {
        return false;
    }

    @Override
    public void updateFood(int changeAmount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getFood() {
        return 0;
    }

    @Override
    public void setMarkerOn(int marker, TeamColour colour) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMarkerOff(int marker, TeamColour colour) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAntId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAntId() {
        return -1;
    }
    
     @Override
    public int[] getRedMarkers() {
        return redMarkers;
    }

    @Override
    public int[] getBlackMarkers() {
        return blackMarkers;
    }
}

class RedCell implements Cell {

    boolean antPresent = true;
    Integer food = 0;
    public int antId = -1; // -1 means no ant
    int[] redMarkers = {0, 0, 0, 0, 0, 0};
    int[] blackMarkers = {0, 0, 0, 0, 0, 0};
    
    public RedCell() {
    }

    @Override
    public String toString() {
        return "+";
    }

    public void setAntPresent(boolean present) {
        antPresent = present;
    }

    @Override
    public boolean getAntPresent() {
        return antId >= 0;
    }

    @Override
    public void updateFood(int changeAmount) {
        food += changeAmount;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public void setMarkerOn(int marker, TeamColour colour) {
        if (colour.equals(colour.RED)) {
            redMarkers[marker] = 1;
        } else {
            blackMarkers[marker] = 1;
        }
    }

    @Override
    public void setMarkerOff(int marker, TeamColour colour) {
        if (colour.equals(colour.RED)) {
            redMarkers[marker] = 0;
        } else {
            blackMarkers[marker] = 0;
        }
    }
    
    @Override
    public void setAntId(int id) {
        antId = id;
    }

    @Override
    public int getAntId() {
        return antId;
    }
    
     @Override
    public int[] getRedMarkers() {
        return redMarkers;
    }

    @Override
    public int[] getBlackMarkers() {
        return blackMarkers;
    }
}

class BlackCell implements Cell {

    boolean antPresent = true;
    public int antId = -1; // -1 means no ant
    int[] redMarkers = {0, 0, 0, 0, 0, 0};
    int[] blackMarkers = {0, 0, 0, 0, 0, 0};
    Integer food = 0;
    
    public BlackCell() {

    }

    @Override
    public String toString() {
        return "-";
    }

    public void setAntPresent(boolean present) {
        antPresent = present;
    }

    @Override
    public boolean getAntPresent() {
        return antId >= 0;
    }

    @Override
    public void updateFood(int changeAmount) {
        food += changeAmount;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public void setMarkerOn(int marker, TeamColour colour) {
        if (colour.equals(colour.RED)) {
            redMarkers[marker] = 1;
        } else {
            blackMarkers[marker] = 1;
        }
    }

    @Override
    public void setMarkerOff(int marker, TeamColour colour) {
        if (colour.equals(colour.RED)) {
            redMarkers[marker] = 0;
        } else {
            blackMarkers[marker] = 0;
        }
    }
    
    @Override
    public void setAntId(int id) {
        antId = id;
    }

    @Override
    public int getAntId() {
        return antId;
    }
    
     @Override
    public int[] getRedMarkers() {
        return redMarkers;
    }

    @Override
    public int[] getBlackMarkers() {
        return blackMarkers;
    }
}
