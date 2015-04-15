/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AntGame.Game;

import java.io.*;
import java.util.*;

/**
 *
 * @author tw242
 */
public class WorldBuilder {

    HashMap<Coordinate, Cell> worldMap;
    int xSize, ySize;
    String line, filePath;

    public WorldBuilder(String filePath) throws FileNotFoundException, IOException {
        this.filePath = filePath;
        int yCounter = 0, xCounter;

        BufferedReader worldReader = new BufferedReader(new FileReader(filePath));
        xSize = Integer.parseInt(worldReader.readLine().trim());
        ySize = Integer.parseInt(worldReader.readLine().trim());

        worldMap = new HashMap(xSize * ySize);

        line = worldReader.readLine().trim().replaceAll("\\s+", "");

        while (line != null && yCounter <= ySize - 1) {
            xCounter = 0;
            String[] mapLine = line.trim().split("", xSize + 1);
            for (String s : mapLine) {
                if (s.equals("#")) {
                    worldMap.put(new Coordinate(xCounter, yCounter), new RockyCell());
                    xCounter++;
                } else if (s.equals(".")) {
                    worldMap.put(new Coordinate(xCounter, yCounter), new ClearCell());
                    xCounter++;
                } else if (s.equals("+")) {
                    worldMap.put(new Coordinate(xCounter, yCounter), new RedCell());
                    xCounter++;
                } else if (s.equals("-")) {
                    worldMap.put(new Coordinate(xCounter, yCounter), new BlackCell());
                    xCounter++;
                } else if (s.matches("\\d")) {
                    worldMap.put(new Coordinate(xCounter, yCounter), new ClearCell(Integer.parseInt(s)));
                    xCounter++;
                }
            }
            //System.out.println(yCounter + " , " + ySize);
            if (yCounter != ySize - 1) {
                line = worldReader.readLine().trim().replaceAll("\\s+", "");
            }
            yCounter++;
        }
    }

    public void rebuild() throws FileNotFoundException, IOException {
        int yCounter = 0, xCounter;

        BufferedReader worldReader = new BufferedReader(new FileReader(filePath));
        xSize = Integer.parseInt(worldReader.readLine().trim());
        ySize = Integer.parseInt(worldReader.readLine().trim());
        line = worldReader.readLine().trim().replaceAll("\\s+", "");

        while (line != null && yCounter <= ySize - 1) {
            xCounter = 0;
            String[] mapLine = line.trim().split("", xSize + 1);
            for (String s : mapLine) {
                if (s.equals("#")) {
                    worldMap.put(new Coordinate(xCounter, yCounter), new RockyCell());
                    xCounter++;
                } else if (s.equals(".")) {
                    worldMap.put(new Coordinate(xCounter, yCounter), new ClearCell());
                    xCounter++;
                } else if (s.equals("+")) {
                    worldMap.put(new Coordinate(xCounter, yCounter), new RedCell());
                    xCounter++;
                } else if (s.equals("-")) {
                    worldMap.put(new Coordinate(xCounter, yCounter), new BlackCell());
                    xCounter++;
                } else if (s.matches("\\d")) {
                    worldMap.put(new Coordinate(xCounter, yCounter), new ClearCell(Integer.parseInt(s)));
                    xCounter++;
                }
            }
            //System.out.println(yCounter + " , " + ySize);
            if (yCounter != ySize - 1) {
                line = worldReader.readLine().trim().replaceAll("\\s+", "");
            }
            yCounter++;
        }
    }

    public HashMap<Coordinate, Cell> getWorld() {
        return worldMap;
    }

    public int getXSize() {
        return xSize;
    }

    public int getYSize() {
        return ySize;
    }

    public void printMap() {
        String line = "";
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                line += (worldMap.get(new Coordinate(j, i)) + " ");
            }
            line = line.trim();
            line += "\n";
        }
        System.out.println(line);
    }
}
