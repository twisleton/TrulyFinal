package AntGame.Game;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author DSGI
 */
public class WorldValidator {
    
    private static int xSize, ySize, yCounter;
    private static String line;
    
    public static boolean validateWorld(String fileName) throws FileNotFoundException, IOException {
        BufferedReader worldReader = new BufferedReader(new FileReader(fileName));
        yCounter = 0;
        boolean check;

        // set up the xSize and ySize based off of first two lines.
        // If they aren't numbers, it's not valid.
        line = worldReader.readLine().trim();
        if (!line.matches("\\d+")) {
            return false;
        }
        xSize = Integer.parseInt(line.trim());
        
        line = worldReader.readLine().trim();
        if (!line.matches("\\d+")) {
            return false;
        }
        ySize = Integer.parseInt(line.trim());
        
        line = worldReader.readLine().trim().replaceAll("\\s+", "");
        while (yCounter < ySize) { // look at the rest of the lines in the list
            yCounter++;
            check = validateLine(line);
            if (!check) {
                return false;
            }
            
            if (yCounter != ySize) {
                try {
                    line = worldReader.readLine().trim().replaceAll("\\s+", "");
                } catch (NullPointerException e) {
                    return false;
                }
            }
        }
        
        return yCounter == ySize;
    }
    
    private static boolean validateLine(String line) {
        if (line.length() != xSize) {
            return false;
        }
        
        if (yCounter == 1 || yCounter == ySize) {
            return validateBorder(line);
        } else {
            return validateInside(line);
        }
        
    }
    
    private static boolean validateBorder(String s) {
        String[] border = s.trim().split("", xSize + 1);
        for (int i = 1; i <= xSize; i++) {
            if (!border[i].equals("#")) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean validateInside(String s) {
        String[] worldLine = s.trim().split("", xSize + 1);

        //make sure the first part is rocky terrain
        if (!worldLine[1].equals("#")) {
            return false;
        }

        // go through the rest of the line and make sure it uses valid syntax
        for (int i = 2; i <= xSize - 1; i++) {
            if (!worldLine[i].equals("#") && !worldLine[i].equals(".") && !worldLine[i].equals("+")
                    && !worldLine[i].equals("-") && !worldLine[i].matches("\\d")) {
                return false;
            }
        }

        // make sure last part is rocky terrain
        if (!worldLine[xSize].equals("#")) {
            return false;
        }
        
        return true;
    }
}
