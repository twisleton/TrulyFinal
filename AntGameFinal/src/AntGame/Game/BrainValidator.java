package AntGame.Game;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author thoma_000
 */


public class BrainValidator {
    // TODO make sure there are no states that go to something that doesn't
    // exist!
    static BufferedReader brainReader;
    
    /**
     * 
     * @param filePath
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void validateBrain(String filePath) throws FileNotFoundException, IOException, InvalidBrainException {
        System.out.println(filePath);
        brainReader = new BufferedReader(new FileReader(filePath));
        if (!validateFile()) {
            throw new InvalidBrainException();
        }
    }

    /**
     * 
     * @return
     * @throws IOException 
     */
    private static boolean validateFile() throws IOException {
        String line = brainReader.readLine();
        boolean check;
        
        while(line != null) { // look at every line in the file
            
            check = validateLine(line.trim());
            if (!check && !line.equals("")) {
                // if false the ant must be invalid. 
                return check;
            }
            line = brainReader.readLine();
        }     
        return true;
    }
    
    /**
     * 
     * @param s
     * @return 
     */
    public static boolean validateLine(String s) {
        // look at the first word in the string, if valid, send to correct validator
        // else return false
        String[] instructionSplit = s.split(" ", 2);
        switch(instructionSplit[0]) {
            case "Sense":
                return validateSense(instructionSplit[1]);
            case "Mark":
                return validateUnMark(instructionSplit[1]);
            case "Unmark":
                return validateUnMark(instructionSplit[1]);
            case "PickUp":
                return validatePickUpMove(instructionSplit[1]);
            case "Move":
                return validatePickUpMove(instructionSplit[1]);
            case "Drop":
                return validateDrop(instructionSplit[1]);
            case "Turn":
                return validateTurn(instructionSplit[1]);
            case "Flip":
                return validateFlip(instructionSplit[1]);
            default:
                return false;
        }
    }

    /**
     * Used to check whether sense is correctly structured
     * @param string
     * @return 
     */
    private static boolean validateSense(String string) {
        String[] senseSplit = string.split(" ", 4);
        int st1 = 0, st2 = 0;
        boolean condCheck;
        
        // check if the first value is a sensedir value
        if ((!"Here".equals(senseSplit[0].trim())) && (!"Ahead".equals(senseSplit[0].trim())) && (!"LeftAhead".equals(senseSplit[0].trim())) && (!"RightAhead".equals(senseSplit[0].trim()))) {
            return false;
        }
        
        // check if the second and third are numbers between 0 and 9999
        if (senseSplit[1].matches("\\d+") && senseSplit[2].matches("\\d+")) {
            st1 = Integer.parseInt(senseSplit[1]);
            st2 = Integer.parseInt(senseSplit[2]);
            if ((st1 > 9999 || st1 < 0) || (st2 > 9999 || st2 < 0)) {
                return false;
            }
        } else {
            return false;
        }
        
        condCheck = validateCond(senseSplit[3]);
        if (!condCheck) {
            return condCheck;
        }  
        return true;
    }

    /**
     * Because of the marker i, it's just easier to validate in its own functions
     * @return 
     */
    private static boolean validateCond(String s) {
        String[] cond = s.split(" ", 2);
        int markeri = 0;
        
        // start by handling Marker i
        if (cond.length == 2) {
            if (!(cond[0].equals("Marker")) && !cond[1].matches("\\d")) {
                return false;
            } else if (Integer.parseInt(cond[1]) > 5 || Integer.parseInt(cond[1]) < 0) { // it must be marker followed by an integer. 
                return false;
            }
        } else if ((!"Friend".equals(cond[0].trim())) && (!"Foe".equals(cond[0].trim())) 
                && (!"FriendWithFood".equals(cond[0].trim())) && (!"FoeWithFood".equals(cond[0].trim())) 
                && (!"Food".equals(cond[0].trim())) && (!"Rock".equals(cond[0].trim())) 
                && (!"FoeMarker".equals(cond[0].trim())) && (!"Home".equals(cond[0].trim())) 
                && (!"FoeHome".equals(cond[0].trim()))){ // check everything else 
            return false;
        }
               
        return true;
    }

    /**
     * used to check whether Mark and Unmark are correctly structured
     * @param string
     * @return 
     */
    private static boolean validateUnMark(String string) {
        String[] markSplit = string.split(" ", 2);
        
        // is it the right length?
        if (markSplit.length != 2) {
            return false;
        }
        
        // is i in the right boundary
        if (markSplit[0].matches("\\d")) {
            if (Integer.parseInt(markSplit[0]) > 5 || Integer.parseInt(markSplit[0]) < 0) {
                return false;
            }
        } else {
            return false;
        }
        
        // is st in the right boundary
        if (markSplit[1].matches("\\d+")) {
            if (Integer.parseInt(markSplit[1]) > 9999 || Integer.parseInt(markSplit[1]) < 0) {
                return false;
            }
        } else {
            return false;
        }
        
        return true;
    }

    /**
     * Used to check whether PickUp and Move are correctly structured. 
     * @param string
     * @return 
     */
    private static boolean validatePickUpMove(String string) {
        String[] moveSplit = string.split(" ", 2);
        int st1 = 0, st2 = 0;
        
        if (moveSplit.length != 2) {
            return false;
        }
        
        if (moveSplit[0].matches("\\d+") && moveSplit[1].matches("\\d+")) {
            st1 = Integer.parseInt(moveSplit[0]);
            st2 = Integer.parseInt(moveSplit[1]);
            if ((st1 > 9999 || st1 < 0) || (st2 > 9999 || st2 < 0)) {
                return false;
            }
        } else {
            return false;
        }
        
        return true;
    }

    /**
     * Used to check whether Drop is correctly structured
     * @param string
     * @return 
     */
    private static boolean validateDrop(String string) {
        String[] dropSplit = string.split(" ", 1);
        int st1 = 0;
        
        if (dropSplit[0].matches("\\d+")) {
            if (Integer.parseInt(dropSplit[0]) < 0 || Integer.parseInt(dropSplit[0]) > 9999) {
                return false;
            }
        } else {
            return false;
        }
        
        return true;
    }

    /**
     * check whether Turn is correctly structured
     * @param string
     * @return 
     */
    private static boolean validateTurn(String string) {
        String[] turnSplit = string.split(" ", 2);
        int st1 = 0;
        
        if (!(turnSplit[0].equals("Left")) && !(turnSplit[0].equals("Right"))) {
            return false;
        }
        
        if (turnSplit[1].matches("\\d+")) {
            if (Integer.parseInt(turnSplit[1]) < 0 || Integer.parseInt(turnSplit[1]) > 9999) {
                return false;
            }
        } else {
            return false;
        }
        
        return true;
    }

    /**
     * Check whether Flip is correctly structured
     * @param string
     * @return 
     */
    private static boolean validateFlip(String string) {
        String[] flipSplit = string.split(" ", 3);
        int st1 = 0, st2 = 0, p = 0;
        
        if (flipSplit[0].matches("\\d")) {
            if (Integer.parseInt(flipSplit[0]) <= 0) {
                return false;
            }
        } else {
            return false;
        }
        
        if (flipSplit[1].matches("\\d+") && flipSplit[2].matches("\\d+")) {
            st1 = Integer.parseInt(flipSplit[1]);
            st2 = Integer.parseInt(flipSplit[2]);
            if ((st1 > 9999 || st1 < 0) || (st2 > 9999 || st2 < 0)) {
                System.out.println("line 268");
                return false;
            }
        } else {
            System.out.println("line 272");
            return false;
        }
        
        return true;
    }
}