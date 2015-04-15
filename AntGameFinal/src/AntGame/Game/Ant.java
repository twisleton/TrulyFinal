/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AntGame.Game;

import AntGame.TeamColour;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author tw242
 */
public class Ant {

    private TeamColour teamColour;
    private ArrayList<Instruction> antBrain;
    private HashMap<Coordinate, Cell> gameWorld;
    private HashMap<Integer, Ant> gameAnts;
    public Coordinate position;
    public int id, restCount = 0, brainState = 0, direction = 0;
    public boolean carryingFood = false, dead = false;

    /**
     * Creates a new ant with a pre-chosen brain (FSA), colour, start position
     * and id.
     *
     * @param brain the finite state machine to determine how the ant acts
     * @param colour the team the ant is a part of
     * @param startPosition the cell it initially starts in
     * @param antId the order in which it was instantiated, stored in HashMap
     * this way
     * @throws FileNotFoundException
     * @throws IOException
     * @throws InvalidBrainException
     */
    public Ant(ArrayList<Instruction> brain, TeamColour colour, Coordinate startPosition, int antId) throws FileNotFoundException, IOException, InvalidBrainException {
        teamColour = colour;
        antBrain = brain;
        position = startPosition;
        id = antId;
    }

    /**
     *
     * @return the team color
     */
    public TeamColour getTeam() {
        return teamColour;
    }

    /**
     * Gets this ant to play one round by executing instructions from its brain.
     *
     * @param gameSim
     */
    public void playRound(GameSim gameSim) {
        // need to do a check to see if this ant can die or not.
        // (surrounded by 5+ enemy ants)
        if (!checkDeath(gameSim)) {

            if (restCount == 0) {
                // if the ant is awake perform the current state in the brain.
                if (antBrain.get(brainState) instanceof Sense) {
                    // perform a sense action
                    sense(gameSim);
                } else if (antBrain.get(brainState) instanceof Mark) {
                    mark(gameSim);
                } else if (antBrain.get(brainState) instanceof Unmark) {
                    // perform a unmark action
                    unMark(gameSim);
                } else if (antBrain.get(brainState) instanceof PickUp) {
                    // perform a PickUp action
                    pickUp(gameSim);
                } else if (antBrain.get(brainState) instanceof Drop) {
                    // perform a drop action
                    drop(gameSim);
                } else if (antBrain.get(brainState) instanceof Turn) {
                    // perform a turn action
                    turn();
                } else if (antBrain.get(brainState) instanceof Move) {
                    // perform a move action
                    move(gameSim);
                } else if (antBrain.get(brainState) instanceof Flip) {
                    // perform a flip action
                    flip();
                }
            } else {
                // otherwise rest(do nothing) for one turn.
                restCount--;
            }
        }
    }

    /**
     * Executes the move instruction. Hexagon moved to is based on direction
     * integer. if d = 0 you move one to the right, if d = 1 you move one right
     * one down etc. going clockwise.
     */
    private void move(GameSim gameSim) {

        Move move = (Move) antBrain.get(brainState);
        if (gameSim.worldMap.get(adjacentCellPos(position, direction, gameSim.worldMap)) instanceof RockyCell) {
            // do nothing
            brainState = move.st2;
        } else if (adjacentCell(position, direction, gameSim.worldMap).getAntPresent()) {
            // if an ant is present you're not able to move onto the same 
            // cell, go to failure state
            brainState = move.st2;
        } else {
            // You're not trying to move onto a rock, you're not moving onto
            // another ant so you can move in the direction your facing.
            // tell the world you're not on the old cell anymore
            gameSim.worldMap.get(position).setAntPresent(false);
            gameSim.worldMap.get(position).setAntId(-1);
            // move to the adjacent cell
            this.position = adjacentCellPos(position, direction, gameSim.worldMap);

            // tell the world you are now on that cell
            gameSim.worldMap.get(position).setAntPresent(true);
            gameSim.worldMap.get(position).setAntId(id);

            brainState = move.st1;
            restCount = 14; // have to rest for 14 turns after moving
        }

    }

    /**
     * Returns the coordinate of the adjacent cell in the specified direction.
     *
     * @param p the reference position
     * @param direction the direction to look
     * @param worldMap map of the game world to reference
     * @return The coordinate of the adjacent cell
     */
    private Coordinate adjacentCellPos(Coordinate p, int direction, HashMap<Coordinate, Cell> worldMap) {
        Coordinate toFind;
        switch (direction) {
            case 0:
                // This is fine
                toFind = new Coordinate(p.getxPos() + 1, p.getyPos());
                break;
            case 1:
                // y even = (x, y+1), y odd = (x+1, y+1)
                if (p.getyPos() % 2 == 0) {
                    toFind = new Coordinate(p.getxPos(), p.getyPos() + 1);
                } else {
                    toFind = new Coordinate(p.getxPos() + 1, p.getyPos() + 1);
                }
                break;
            case 2:
                // y even = (x-1, y+1), y odd = (x, y+1)
                if (p.getyPos() % 2 == 0) {
                    toFind = new Coordinate(p.getxPos() - 1, p.getyPos() + 1);
                } else {
                    toFind = new Coordinate(p.getxPos(), p.getyPos() + 1);
                }
                break;
            case 3:
                // This is fine
                toFind = new Coordinate(p.getxPos() - 1, p.getyPos());
                break;
            case 4:
                // y even = (x-1, y-1), y odd = (x, y-1)
                if (p.getyPos() % 2 == 0) {
                    toFind = new Coordinate(p.getxPos() - 1, p.getyPos() - 1);
                } else {
                    toFind = new Coordinate(p.getxPos(), p.getyPos() - 1);
                }
                break;
            case 5:
                // y even = (x, y-1), y odd = (x+1, y-1)
                if (p.getyPos() % 2 == 0) {
                    toFind = new Coordinate(p.getxPos(), p.getyPos() - 1);
                } else {
                    toFind = new Coordinate(p.getxPos() + 1, p.getyPos() - 1);
                }
                break;
            default:
                // should never get here
                System.out.println("What havve you done!?");
                toFind = new Coordinate(p.getxPos(), p.getyPos());
        }
        return toFind;
    }

    /**
     * Returns the Cell object of the adjacent cell in the specified direction.
     *
     * @param p the reference position
     * @param direction the direction to look in
     * @param worldMap map of the game world to reference
     * @return The adjacent cell in the specified direction.
     */
    private Cell adjacentCell(Coordinate p, int direction, HashMap<Coordinate, Cell> worldMap) {
        Coordinate toFind;
        switch (direction) {
            case 0:
                // This is fine
                toFind = new Coordinate(p.getxPos() + 1, p.getyPos());
                break;
            case 1:
                // y even = (x, y+1), y odd = (x+1, y+1)
                if (p.getyPos() % 2 == 0) {
                    toFind = new Coordinate(p.getxPos(), p.getyPos() + 1);
                } else {
                    toFind = new Coordinate(p.getxPos() + 1, p.getyPos() + 1);
                }
                break;
            case 2:
                // y even = (x-1, y+1), y odd = (x, y+1)
                if (p.getyPos() % 2 == 0) {
                    toFind = new Coordinate(p.getxPos() - 1, p.getyPos() + 1);
                } else {
                    toFind = new Coordinate(p.getxPos(), p.getyPos() + 1);
                }
                break;
            case 3:
                // This is fine
                toFind = new Coordinate(p.getxPos() - 1, p.getyPos());
                break;
            case 4:
                // y even = (x-1, y-1), y odd = (x, y-1)
                if (p.getyPos() % 2 == 0) {
                    toFind = new Coordinate(p.getxPos() - 1, p.getyPos() - 1);
                } else {
                    toFind = new Coordinate(p.getxPos(), p.getyPos() - 1);
                }
                break;
            case 5:
                // y even = (x, y-1), y odd = (x+1, y-1)
                if (p.getyPos() % 2 == 0) {
                    toFind = new Coordinate(p.getxPos(), p.getyPos() - 1);
                } else {
                    toFind = new Coordinate(p.getxPos() + 1, p.getyPos() - 1);
                }
                break;
            default:
                // should never get here
                System.out.println("What havve you done!?");
                toFind = new Coordinate(p.getxPos(), p.getyPos());
        }
        return worldMap.get(toFind);
    }

    /**
     * Execute the turn instruction. Increments or decrements the direction int
     * based on whether you are turning left or right.
     */
    private void turn() {
        Turn turn = (Turn) antBrain.get(brainState);

        if (turn.lr instanceof Left) { //turn left
            if (direction == 0) {
                direction = 5;
            } else {
                direction--;
            }
        } else { // turn right
            if (direction == 5) {
                direction = 0;
            } else {
                direction++;
            }
        }
        // advance to required brainState
        brainState = turn.st;

    }

    /**
     * Executes the flip instruction. Chooses a random number between 0 and p-1.
     * goes to st1 if the result is 0 or st2 otherwise. e.g. if p = 2, it's a
     * 50/50 chance, if p = 4 it's 25/75 etc.
     */
    private void flip() {
        Flip flip = (Flip) antBrain.get(brainState);
        Random rand = new Random();
        int randomFlip = rand.nextInt(flip.p);

        if (randomFlip == 0) { // go to st1
            brainState = flip.st1;
        } else { // go to st 2
            brainState = flip.st2;
        }
    }

    /**
     * Drop whatever food your carrying
     *
     * @param gameSim the gameWorld to reference
     */
    private void drop(GameSim gameSim) {
        Drop drop = (Drop) antBrain.get(brainState);
        // set carryingFood to false if possible, increment the current cell's food
        // count by 1 and move to st
        if (carryingFood) {
            carryingFood = false;
            gameSim.worldMap.get(position).updateFood(1);
        }
        brainState = drop.st;
    }

    /**
     * Pickup food on cell if available
     *
     * @param gameSim the gameWorld to reference
     */
    private void pickUp(GameSim gameSim) {
        PickUp pickUp = (PickUp) antBrain.get(brainState);

        if (gameSim.worldMap.get(position).getFood() > 0 && !carryingFood) { // if there is food on the cell...
            // pick it up (decrement food on cell by 1)
            carryingFood = true;
            gameSim.worldMap.get(position).updateFood(-1);
            brainState = pickUp.st1;
        } else {
            brainState = pickUp.st2;
        }

    }

    /**
     * Marks the current cell with a marker numbered 0 - 5.
     *
     * @param gameSim world to reference
     */
    private void mark(GameSim gameSim) {
        Mark mark = (Mark) antBrain.get(brainState);
        gameSim.worldMap.get(position).setMarkerOn(mark.i, teamColour);
        System.out.println(gameSim.worldMap.get(position).getBlackMarkers()[1]);
        brainState = mark.st;
    }

    /**
     * Unmarks the specified marker from the cell.
     *
     * @param gameSim world to reference
     */
    private void unMark(GameSim gameSim) {
        Unmark unmark = (Unmark) antBrain.get(brainState);
        gameSim.worldMap.get(position).setMarkerOff(unmark.i, teamColour);
        brainState = unmark.st;
    }

    /**
     * Checks to see if the ant is dead or able to die.
     *
     * @param gameSim
     * @return true if it's dead, false otherwise
     */
    private boolean checkDeath(GameSim gameSim) {
        int adjacentAnt = 0;

        if (dead) {
            return true;
        }
        
//        for (int i = 0; i <= 5; i++) {
//            Cell cellToCheck = adjacentCell(position, i, gameSim.worldMap);
//            Ant antToCheck = gameSim.ants.get(cellToCheck.getAntId());
//            if (!(cellToCheck instanceof RockyCell) && cellToCheck.getAntId() != -1) {
//                if (teamColour.equals(TeamColour.RED)) {
//                    if (antToCheck.teamColour.equals(TeamColour.BLACK)) {
//                        adjacentAnt++;
//                    }
//
//                } else {
//                    if (antToCheck.teamColour.equals(TeamColour.RED)) {
//                        adjacentAnt++;
//                    }
//                }
//            }
//        }
        
        if (adjacentAnt >= 5) {
            // kill
            gameSim.worldMap.get(position).setAntPresent(false);
            gameSim.worldMap.get(position).setAntId(-1);

            if (carryingFood) {
                gameSim.worldMap.get(position).updateFood(1);
            }
            gameSim.worldMap.get(position).updateFood(1);
            System.out.println("Ant " + id + " Died");

            dead = true;
            position = new Coordinate(-1, -1);

            return true;
        }
        return false;
    }

    /**
     * Executes a sense instruction
     * @param gameSim 
     */
    private void sense(GameSim gameSim) {
        Sense sense = (Sense) antBrain.get(brainState);
        Coordinate posToCheck = position; // position to check the condition

        // establish what cell to check the condition in.
        if (sense.senseDir instanceof Here) { // Cell we're currently in
            posToCheck = position;
        } else if (sense.senseDir instanceof Ahead) { // cell directly ahead of us
            posToCheck = adjacentCellPos(position, direction, gameSim.worldMap);
        } else if (sense.senseDir instanceof LeftAhead) { // cell left ahead of us
            if (direction == 0) {
                posToCheck = adjacentCellPos(position, 5, gameSim.worldMap);
            } else {
                posToCheck = adjacentCellPos(position, direction - 1, gameSim.worldMap);
            }
        } else { // cell right ahead of us
            if (direction == 5) {
                posToCheck = adjacentCellPos(position, 0, gameSim.worldMap);
            } else {
                posToCheck = adjacentCellPos(position, direction + 1, gameSim.worldMap);
            }
        }

        if (condCheck(posToCheck, sense.cond, gameSim)) {
            brainState = sense.st1;
        } else {
            brainState = sense.st2;
        }
    }

    /**
     * Checks to see if the condition in a sense instruction will hold.
     * @param posToCheck
     * @param cond
     * @param gameSim
     * @return 
     */
    private boolean condCheck(Coordinate posToCheck, Cond cond, GameSim gameSim) {

        if (cond instanceof Friend) {
            // check if the ant in the specified cell has the same colour
            int idToCheck = gameSim.worldMap.get(posToCheck).getAntId();
            if (idToCheck != -1) {
                if (gameSim.ants.get(idToCheck).teamColour.equals(teamColour)) {
                    return true;
                }
            }
            return false;

        } else if (cond instanceof Foe) {
            // Check if the ant in the speficied cell has the opposite colour
            int idToCheck = gameSim.worldMap.get(posToCheck).getAntId();
            if (idToCheck != -1) {
                if (!gameSim.ants.get(idToCheck).teamColour.equals(teamColour)) {
                    return true;
                }
            }
            return false;

        } else if (cond instanceof FriendWithFood) {
            // check if it is the same colour and is carrying food
            int idToCheck = gameSim.worldMap.get(posToCheck).getAntId();
            if (idToCheck != -1) { // is there an ant on the cell?
                Ant antToCheck = gameSim.ants.get(idToCheck);
                if (antToCheck.teamColour.equals(teamColour)) {
                    return antToCheck.carryingFood; // are the carrying food?
                }
            }
            return false;

        } else if (cond instanceof FoeWithFood) {
            // check if it is the opposite colour and is carrying food
            int idToCheck = gameSim.worldMap.get(posToCheck).getAntId();
            if (idToCheck != -1) { // is there an ant on the cell?
                Ant antToCheck = gameSim.ants.get(idToCheck);
                if (!antToCheck.teamColour.equals(teamColour)) {
                    return antToCheck.carryingFood; // are the carrying food?
                }
            }
            return false;

        } else if (cond instanceof Food) {
            // check to see if the cell has food in it
            if (gameSim.worldMap.get(posToCheck) instanceof ClearCell) {
                return gameSim.worldMap.get(posToCheck).getFood() > 0;
            }
            return false;

        } else if (cond instanceof Rock) {
            // check to see if the cell in question is a rock
            return gameSim.worldMap.get(posToCheck) instanceof RockyCell;

        } else if (cond instanceof Marker) {
            // markers like this are annoying
            Marker marker = (Marker)cond;
            if (teamColour.equals(TeamColour.BLACK)) {
                int[] markers = gameSim.worldMap.get(posToCheck).getBlackMarkers();
                return markers[marker.marker] == 1;
            } else {
                int[] markers = gameSim.worldMap.get(posToCheck).getRedMarkers();
                return markers[marker.marker] == 1;
            }

        } else if (cond instanceof FoeMarker) {
            // returns true if there is at least some kind of enemy marker on the
            // cell.
            Cell toCheck = gameSim.worldMap.get(posToCheck);
            if (teamColour.equals(TeamColour.RED)) {
                for (int i : toCheck.getBlackMarkers()) {
                    if (i == 1) {
                        return true;
                    }
                }
            } else {
                for (int i : toCheck.getRedMarkers()) {
                    if (i == 1) {
                        return true;
                    }
                }
            }
            return false;

        } else if (cond instanceof Home) {
            if (teamColour.equals(TeamColour.RED)) {
                return gameSim.worldMap.get(posToCheck) instanceof RedCell;
            } else {
                return gameSim.worldMap.get(posToCheck) instanceof BlackCell;
            }

        } else if (cond instanceof FoeHome) {
            if (teamColour.equals(TeamColour.BLACK)) {
                return gameSim.worldMap.get(posToCheck) instanceof RedCell;
            } else {
                return gameSim.worldMap.get(posToCheck) instanceof BlackCell;
            }
        }
        return false;
    }

}
