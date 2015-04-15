package AntGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorldFileGeneratorGood {

    char[][] worldMap;

    public WorldFileGeneratorGood() throws FileNotFoundException, UnsupportedEncodingException {
        this.blankGridGenerator();
        this.randomRockSpawn(60);
        this.randomFoodSpawn();
        this.antHillSpawn();
        this.printWorldToFile();
    }

    /*
     * Fills the worldMap array with a rocky border and clear cell interior.
     */
    public void blankGridGenerator() {
        worldMap = new char[150][150];

        /*
         * Fill the first row with rocky cells
         */
        for (int i = 0; i < 150; i++) {
            worldMap[i][0] = '#';
        }

        /*
         * Go through the worldMap array setting the first cell of each
         * row to be rocky, the middle cells to be clear, and the final cells
         * of each row to be rocky.         
         */
        for (int i = 0; i < 149; i++) {
            worldMap[0][i] = '#';
            for (int j = 1; j < 149; j++) {
                worldMap[i][j] = '.';
            }
            worldMap[149][i] = '#';
        }

        /*
         * Fill the final row with rocky cells
         */
        for (int i = 0; i < 150; i++) {
            worldMap[i][149] = '#';
        }
    }

    /*
     * prints the worldMap array.
     */
    public void printMap() {
        for (int i = 0; i < 150; i++) {
            if (i % 2 == 0) {
                //System.out.print(" ");
            }
            for (int j = 0; j < 150; j++) {
                System.out.print(worldMap[j][i] + " ");
            }
            System.out.println("");
        }
    }

    /*
     * Places 14 rock clusters on the map, cluster size = approximateSizeofRocks+-10 
     */
    public void randomRockSpawn(int approximateSizeOfRocks) {

        /*
         * Iterate 14 times (number of rock clusters for contest maps). 
         */
        for (int i = 0; i < 14; i++) {

            /* Generate a random X and Y coordinate for the rock cluster, place # 
             * in that array position. 
             */
            int randomXCoordinate = 1 + (int) (Math.random() * 149);
            int randomYCoordinate = 1 + (int) (Math.random() * 149);
            worldMap[randomXCoordinate][randomYCoordinate] = '#';

            /*
             * Calculate size of each rock cluster(currentRockSize): 
             * approximateSizeOfRocks + or - a random number between 1 and 10.
             */
            Random random = new Random();
            int rockSizeDifferenceFromApproximation = 1 + (int) (Math.random() * 10);
            int currentRockSize;
            if (random.nextBoolean() == true) {
                currentRockSize = approximateSizeOfRocks + rockSizeDifferenceFromApproximation;
            } else {
                currentRockSize = approximateSizeOfRocks - rockSizeDifferenceFromApproximation;
            }

            /*
             * Iterate through to currentRockSize.
             */
            for (int j = 0; j < currentRockSize - 1; j++) {

                /*
                 * Randomly increment or decrement randomXCoordinate or
                 * randomYCoordinate.
                 */
                if (random.nextBoolean() == true) {
                    if (random.nextBoolean() == true) {
                        randomXCoordinate++;
                    } else {
                        randomXCoordinate--;
                    }
                } else {
                    if (random.nextBoolean() == true) {
                        randomYCoordinate++;
                    } else {
                        randomXCoordinate--;
                    }
                }

                /*
                 * If randomXCoordinate and randomYCoordinate are in bounds,
                 * add # to that position in worldMap array.
                 */
                if (1 < randomXCoordinate && 150 > randomXCoordinate && 1 < randomYCoordinate && 150 > randomYCoordinate) {
                    worldMap[randomXCoordinate][randomYCoordinate] = '#';
                }
            }
        }
    }

    /*
     * Places 14 rock clusters on the map, cluster size = approximateSizeofRocks+-10 
     */
//    public void randomRockSpawn2(int approximateSizeOfRocks) {
//
//        /*
//         * Iterate 14 times (number of rock clusters for contest maps). 
//         */
//        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
//
//            /* Generate a random X and Y coordinate for the rock cluster, place # 
//             * in that array position. 
//             */
//            int randomXCoordinate = 1 + (int) (Math.random() * 148);
//            int randomYCoordinate = 1 + (int) (Math.random() * 148);
//            worldMap[randomXCoordinate][randomYCoordinate] = alphabet;
//
//            /*
//             * Calculate size of each rock cluster(currentRockSize): 
//             * approximateSizeOfRocks + or - a random number between 1 and 10.
//             */
//            Random random = new Random();
//            int rockSizeDifferenceFromApproximation = 1 + (int) (Math.random() * 10);
//            int currentRockSize;
//            if (random.nextBoolean() == true) {
//                currentRockSize = approximateSizeOfRocks + rockSizeDifferenceFromApproximation;
//            } else {
//                currentRockSize = approximateSizeOfRocks - rockSizeDifferenceFromApproximation;
//            }
//
//            /*
//             * Iterate through to currentRockSize.
//             */
//            for (int j = 0; j < currentRockSize - 1; j++) {
//
//                /*
//                 * Randomly increment or decrement randomXCoordinate or
//                 * randomYCoordinate.
//                 */
//                if (random.nextBoolean() == true) {
//                    if (random.nextBoolean() == true) {
//                        randomXCoordinate++;
//                    } else {
//                        randomXCoordinate--;
//                    }
//                } else {
//                    if (random.nextBoolean() == true) {
//                        randomYCoordinate++;
//                    } else {
//                        randomXCoordinate--;
//                    }
//                }
//
//                /*
//                 * If randomXCoordinate and randomYCoordinate are in bounds,
//                 * add # to that position in worldMap array.
//                 */
//                if (1 < randomXCoordinate && 149 > randomXCoordinate && 1 < randomYCoordinate && 149 > randomYCoordinate) {
//                    worldMap[randomXCoordinate][randomYCoordinate] = alphabet;
//                }
//            }
//
//            Pattern p = Pattern.compile("A-Z");
//            Matcher m = p.matcher("aaaaab");
//            boolean b = m.matches();
//
//
//
//            for (int i = 1; i < 148; i++) {
//                for (int j = 1; j < 148; j++) {                    
//                    if (worldMap[i][j]) {
//                        if (worldMap[i][j + 1] != '.' || worldMap[i + 1][j] != worldMap[i][j]) {
//                            worldMap[i][j + 1] = '.';
//                        }
//
//                        if (worldMap[i][j - 1] != '.' || worldMap[i + 1][j] != worldMap[i][j]) {
//                            worldMap[i][j - 1] = '.';
//                        }
//
//                        if (worldMap[i + 1][j] != '.' || worldMap[i + 1][j] != worldMap[i][j]) {
//                            worldMap[i + 1][j] = '.';
//                        }
//
//                        if (worldMap[i - 1][j] != '.' || worldMap[i + 1][j] != worldMap[i][j]) {
//                            worldMap[i - 1][j] = '.';
//                        }
//
//                        if (worldMap[i + 1][j + 1] != '.' || worldMap[i + 1][j] != worldMap[i][j]) {
//                            worldMap[i + 1][j + 1] = '.';
//                        }
//
//                        if (worldMap[i + 1][j - 1] != '.' || worldMap[i + 1][j] != worldMap[i][j]) {
//                            worldMap[i + 1][j - 1] = '.';
//                        }
//
//                        if (worldMap[i - 1][j + 1] != '.' || worldMap[i + 1][j] != worldMap[i][j]) {
//                            worldMap[i - 1][j + 1] = '.';
//                        }
//
//                        if (worldMap[i - 1][j - 1] != '.' || worldMap[i + 1][j] != worldMap[i][j]) {
//                            worldMap[i - 1][j - 1] = '.';
//                        }
//
//                    }
//                }
//
//            }
//
//        }
//    }
    /*
     * Places 11 food clusters on the map.
     */
    public void randomFoodSpawn() {

        for (int i = 0; i < 11; i++) {
            int randomXCoordinate = 1 + (int) (Math.random() * 144);
            int randomYCoordinate = 1 + (int) (Math.random() * 144);
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    worldMap[randomXCoordinate + j][randomYCoordinate + k] = '5';
                }
            }
        }

    }

    /*
     * 
     */
    public void antHillSpawn() {
        int randomXCoordinate = 8 + (int) (Math.random() * 136);
        int randomYCoordinate = 1 + (int) (Math.random() * 136);
        int currentLineLength = 7;
        int workingYCoordinate = randomYCoordinate;

        /*
         * Generate top half of + anthill.
         */
        for (int j = 0; j < 7; j++) {
            for (int i = randomXCoordinate - (int) Math.ceil(currentLineLength / 2) - 1; i < randomXCoordinate + (int) Math.ceil(currentLineLength / 2); i++) {
                worldMap[i][workingYCoordinate] = '+';
            }
            workingYCoordinate++;
            currentLineLength = currentLineLength + 2;
        }
        currentLineLength = 7;
        workingYCoordinate = randomYCoordinate + 12;

        /*
         * Generate bottom half of + anthill.
         */
        for (int j = 0; j < 7; j++) {
            for (int i = randomXCoordinate - (int) Math.ceil(currentLineLength / 2) - 1; i < randomXCoordinate + (int) Math.ceil(currentLineLength / 2); i++) {
                worldMap[i][workingYCoordinate] = '+';
            }
            workingYCoordinate--;
            currentLineLength = currentLineLength + 2;
        }

        /*
         * Generate coordinates for - anthill.
         */
        int secondRandomXCoordinate = 8 + (int) (Math.random() * 136);
        int secondRandomYCoordinate = 1 + (int) (Math.random() * 136);

        /*
         * Regenerate x and y coordinates of - anthill if they are
         * too close to the + anthill.
         */
        while (Math.abs(randomXCoordinate - secondRandomXCoordinate) < 10 && Math.abs(randomYCoordinate - secondRandomYCoordinate) < 10) {
            secondRandomXCoordinate = 8 + (int) (Math.random() * 136);
            secondRandomYCoordinate = 1 + (int) (Math.random() * 136);
        }

        workingYCoordinate = secondRandomYCoordinate;

        currentLineLength = 7;

        /*
         * Generate top half of - anthill.
         */
        for (int j = 0; j < 7; j++) {
            for (int i = secondRandomXCoordinate - (int) Math.ceil(currentLineLength / 2) - 1; i < secondRandomXCoordinate + (int) Math.ceil(currentLineLength / 2); i++) {
                worldMap[i][workingYCoordinate] = '-';
            }
            workingYCoordinate++;
            currentLineLength = currentLineLength + 2;
        }
        currentLineLength = 7;
        workingYCoordinate = secondRandomYCoordinate + 12;

        /*
         * Generate bottom half of - anthill.
         */
        for (int j = 0; j < 7; j++) {
            for (int i = secondRandomXCoordinate - (int) Math.ceil(currentLineLength / 2) - 1; i < secondRandomXCoordinate + (int) Math.ceil(currentLineLength / 2); i++) {
                worldMap[i][workingYCoordinate] = '-';
            }
            workingYCoordinate--;
            currentLineLength = currentLineLength + 2;
        }

    }

    public void printWorldToFile() throws FileNotFoundException, UnsupportedEncodingException {
        File file = new File("src\\randWorld.world");
        File dir = new File("src");
        try {
            if (!dir.exists()) {
                Files.createDirectory(dir.toPath());
            }
            if (!file.exists()) {
                Files.createFile(file.toPath());
            }
        } catch (Exception e) {
        }
        PrintWriter writer = new PrintWriter("src\\randWorld.world", "UTF-8");
        writer.println("150");
        writer.println("150");

        for (int i = 0; i < 150; i++) {
            if (i % 2 == 0) {
                writer.print(' ');
            }
            for (int j = 0; j < 150; j++) {

                writer.print(worldMap[j][i]);
                writer.print(' ');
            }
            writer.println();
        }
        writer.close();
    }
}
