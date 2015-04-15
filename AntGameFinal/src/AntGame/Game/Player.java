/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AntGame.Game;

import java.util.ArrayList;

/**
 *
 * @author James
 */
public class Player {

    boolean eliminated;
    String playerName, brainPathName;
    ArrayList<Instruction> brain;
    int gamesWon = 0;

    public Player(ArrayList<Instruction> brain, String name, String brainName) {
        eliminated = false;
        this.brain = brain;
        gamesWon = 0;
        playerName = name;
        brainPathName = brainName;
    }

    public String getBrainPathName() {
        return brainPathName;
    }

    public void setBrainPathName(String brainPathName) {
        this.brainPathName = brainPathName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public boolean getEliminated() {
        return eliminated;
    }

    public ArrayList<Instruction> getBrain() {
        return brain;
    }

    public int getGamesWon() {
        return gamesWon;
    }
    
    public void setEliminated(boolean b){
        eliminated = b;
    }
    
    public void incrementGamesWon(){
        gamesWon++;
    }
    

}
