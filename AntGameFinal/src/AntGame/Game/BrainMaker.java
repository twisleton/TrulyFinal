package AntGame.Game;

import java.io.*;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tw242
 */
public class BrainMaker {

    public ArrayList<Instruction> brain;

    /**
     *
     * @param brainPath
     */
    public BrainMaker(String brainPath) throws FileNotFoundException, IOException, InvalidBrainException {
        BrainValidator.validateBrain(brainPath);
        brain = new ArrayList();
        brain = loadBrain(brainPath);
    }

    /**
     * Populates the array list with instructions/states
     *
     * @param filePath
     * @return
     */
    private ArrayList<Instruction> loadBrain(String filePath) throws FileNotFoundException, IOException, InvalidBrainException {
        BufferedReader brainLoader = new BufferedReader(new FileReader(filePath));
        String line = brainLoader.readLine().trim();

        while (line != null) {
            brain.add(loadInstruction(line));

            line = brainLoader.readLine();

            if (line != null) {
                line = line.trim();
            }
        }

        return brain;
    }

    private Instruction loadInstruction(String s) throws InvalidBrainException {
        String[] instructionSplit = s.split(" ", 2);

        switch (instructionSplit[0]) {
            case "Sense":
                return loadSense(instructionSplit[1]);
            case "Mark":
                return loadMark(instructionSplit[1]);
            case "Unmark":
                return loadUnMark(instructionSplit[1]);
            case "PickUp":
                return loadPickUp(instructionSplit[1]);
            case "Move":
                return loadMove(instructionSplit[1]);
            case "Drop":
                return loadDrop(instructionSplit[1]);
            case "Turn":
                return loadTurn(instructionSplit[1]);
            case "Flip":
                return loadFlip(instructionSplit[1]);
        }
        throw new InvalidBrainException();
    }

    /**
     *
     * @param string
     * @return
     */
    private Instruction loadMark(String string) {
        String[] markSplit = string.split(" ", 2);
        return new Mark(Integer.parseInt(markSplit[0]), Integer.parseInt(markSplit[1]));
    }

    /**
     *
     * @param string
     * @return
     */
    private Instruction loadUnMark(String string) {
        String[] markSplit = string.split(" ", 2);
        return new Mark(Integer.parseInt(markSplit[0]), Integer.parseInt(markSplit[1]));
    }

    /**
     *
     * @param string
     * @return
     */
    private Instruction loadMove(String string) {
        String[] moveSplit = string.split(" ", 2);
        return new Move(Integer.parseInt(moveSplit[0]), Integer.parseInt(moveSplit[1]));
    }

    /**
     *
     * @param string
     * @return
     */
    private Instruction loadPickUp(String string) {
        String[] moveSplit = string.split(" ", 2);
        return new PickUp(Integer.parseInt(moveSplit[0]), Integer.parseInt(moveSplit[1]));
    }

    /**
     *
     * @param string
     * @return
     */
    private Instruction loadDrop(String string) {
        String[] dropSplit = string.split(" ", 1);
        return new Drop(Integer.parseInt(dropSplit[0]));
    }

    /**
     *
     * @param string
     * @return
     */
    private Instruction loadTurn(String string) {

        String[] turnSplit = string.split(" ", 2);

        if (turnSplit[0] == "Left") {
            return new Turn(new Left(), Integer.parseInt(turnSplit[1]));
        } else {
            return new Turn(new Right(), Integer.parseInt(turnSplit[1]));
        }

    }

    /**
     *
     * @param string
     * @return
     */
    private Instruction loadFlip(String string) {
        String[] flipSplit = string.split(" ", 3);

        return new Flip(Integer.parseInt(flipSplit[0]), Integer.parseInt(flipSplit[1]), Integer.parseInt(flipSplit[2]));
    }

    private Instruction loadSense(String string) {
        String[] senseSplit = string.split(" ", 4);
        return new Sense(senseDirFromString(senseSplit[0]), Integer.parseInt(senseSplit[1]), Integer.parseInt(senseSplit[2]), condFromString(senseSplit[3]));
    }

    private SenseDir senseDirFromString(String s) {
        switch (s) {
            case "Here":
                return new Here();
            case "Ahead":
                return new Ahead();
            case "LeftAhead":
                return new LeftAhead();
            case "RightAhead":
                return new RightAhead();
            default:
                return null;
        }
    }

    private Cond condFromString(String s) {
        String[] cond = s.split(" ", 2);
        
        if (cond.length == 2) {
            // if we're here then it's using Marker i
            return new Marker(Integer.parseInt(cond[1]));
        }
        
        // otherwise it's any of the others
        switch (s) {
            case "Friend":
                return new Friend();
            case "Foe":
                return new Foe();
            case "FriendWithFood":
                return new FriendWithFood();
            case "FoeWithFood":
                return new FoeWithFood();
            case "Food":
                return new Food();
            case "Rock":
                return new Rock();
            case "FoeMarker":
                return new FoeMarker();
            case "Home":
                return new Home();
            case "FoeHome":
                return new FoeHome();
            default:
                return null;
        }
    }

}
