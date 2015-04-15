/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AntGame.Game;

import AntGame.Hexagon;
import AntGame.TeamColour;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JViewport;

/**
 *
 * @author tw242
 */
public class GameSim {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    ArrayList<Instruction> redBrain, blackBrain;
    protected HashMap<Coordinate, Cell> worldMap;
    protected HashMap<Integer, Ant> ants;
    protected WorldBuilder gameMap;
    int round, redScore, blackScore, roundNumber;
    private Canvas canvas;
    private BufferStrategy bs;
    private int width = (int) screenSize.getWidth() - 150;
    private int height = (width * 9) / 16;
    private JFrame gameFrame;
    boolean winner = false;

    /**
     * Instantiates the first round of the game. Does this by going over the game
     * world and spawning ants at the correct anthill cells.
     *
     * @param redAntBrain the brain being used by the red team (player 1)
     * @param blackAntBrain the brain being used by the black team (player 2)
     * @param map the map to be used in the game
     * @throws FileNotFoundException
     * @throws IOException
     * @throws InvalidBrainException
     */
    public GameSim(ArrayList<Instruction> redAntBrain, ArrayList<Instruction> blackAntBrain, WorldBuilder map) throws FileNotFoundException, IOException, InvalidBrainException {
        int antCounter = 0;
        round = 0;
        redScore = 0;
        blackScore = 0;
        redBrain = redAntBrain;
        blackBrain = blackAntBrain;
        worldMap = map.getWorld();
        ants = new HashMap();

        // go over the map, find the coordinates of anthill cells and make a new
        // ant in that space, basically instantiate the first round of the game. 
        for (int i = 0; i <= map.getXSize(); i++) {
            for (int j = 0; j <= map.getYSize(); j++) {
                if (worldMap.get(new Coordinate(i, j)) instanceof RedCell) {
                    ants.put(antCounter, new Ant(redAntBrain, TeamColour.RED, new Coordinate(i, j), antCounter));
                    worldMap.get(new Coordinate(i, j)).setAntId(antCounter);
                    antCounter++;
                } else if (worldMap.get(new Coordinate(i, j)) instanceof BlackCell) {
                    ants.put(antCounter, new Ant(blackAntBrain, TeamColour.BLACK, new Coordinate(i, j), antCounter));
                    worldMap.get(new Coordinate(i, j)).setAntId(antCounter);
                    antCounter++;
                }
            }
        }

    }

    public boolean getWinner() {
        return winner;
    }

    public boolean runGame(WorldBuilder map) {
        gameFrame = new JFrame();

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));

//        JViewport viewPort = new JViewport();
//        viewPort.add(canvas);

        gameFrame.add(canvas);

//        DrawGrid dg = new DrawGrid(gameMap);
//        gameFrame.setContentPane(dg);

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.pack();
        gameFrame.setVisible(true);
        gameFrame.setLocationRelativeTo(null);

        canvas.createBufferStrategy(2);
        canvas.setFocusable(true);

        bs = canvas.getBufferStrategy();

        double lastTime = System.nanoTime();
        double ns = 1000000000.0 / 60;
        double delta = 0;
        roundNumber = 0;

        while (true) {

            double now = System.nanoTime();
            delta += (now - lastTime) / ns;

            //System.out.println(delta);

            if (delta >= 1) {
                if (roundNumber < 300000) {
                    // update
                    gameFrame.setTitle("Round Number: " + roundNumber + "/300000.");
                    for (int i = 0; i < 60; i++) {
                        for (int j = 0; j < ants.size(); j++) {
                            ants.get(j).playRound(this);
                        }
                        roundNumber++;
                    }
                    delta = 0;
                }
                //delta = 0;
            }
            lastTime = now;

            if (roundNumber % 60 == 0) {
                Graphics g = bs.getDrawGraphics();
                // render


                Point origin = new Point(width / 2, height / 2);
                drawHexGridLoop(g, origin, map.getXSize(), 5, 1, map);

                // end render
                g.dispose();
                bs.show();
            }

            if (roundNumber >= 300000) {
                break;
            }
        }

        for (int i = 0; i <= map.getXSize(); i++) {
            for (int j = 0; j <= map.getYSize(); j++) {
                Cell toCheck = worldMap.get(new Coordinate(i, j));
                if (toCheck instanceof RedCell) {
                    redScore += toCheck.getFood();
                } else if (toCheck instanceof BlackCell) {
                    blackScore += toCheck.getFood();
                }
            }
        }

        String score = "Red Score: " + redScore + "\nBlack Score: " + blackScore;

        if (redScore > blackScore) {
            JOptionPane.showMessageDialog(gameFrame,
                    score + "\nRed Team Wins");
            return true;
        } else {
            JOptionPane.showMessageDialog(gameFrame,
                    score + "\nBlack Team Wins");
            return false;
        }

    }

    public boolean playGame(WorldBuilder map, JFrame roundCounter, Player playerOne, Player playerTwo, JLabel roundTicker, JLabel scoreLabel) {
        try {
            map.rebuild();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameSim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GameSim.class.getName()).log(Level.SEVERE, null, ex);
        }
        redScore = 0; blackScore = 0;
        
        while (round < 300000) { //CHANGE BACK
            roundCounter.setTitle("Current Game: " + playerOne.playerName + " (Red) VS. " + playerTwo.playerName + " (Black) Round " + (round + 1) + "/300000");
            roundTicker.setText("Round " + (round + 1) + "/300000");
            for (int i = 0; i < ants.size(); i++) {
                ants.get(i).playRound(this);
            }
            if (round % 1000 == 0) {
                checkFood(map,scoreLabel);
                redScore = 0;
                blackScore = 0;
            }
            round++;
        }
        // After the game is over tally up the scores by counting the food
        // in each of the anthills
        for (int i = 0; i <= map.getXSize(); i++) {
            for (int j = 0; j <= map.getYSize(); j++) {
                Cell toCheck = worldMap.get(new Coordinate(i, j));
                if (toCheck instanceof RedCell) {
                    redScore += toCheck.getFood();
                } else if (toCheck instanceof BlackCell) {
                    blackScore += toCheck.getFood();
                }
            }
        }

  
        System.out.println("Red Score: " + redScore + "\nBlack Score: " + blackScore);
        
        
        if (redScore > blackScore) {
            winner = true;
            return true;
        } else {
            winner = false;
            return false;
        }
    }

    /**
     *
     * @return string representation of the ants and their IDs
     */
    @Override
    public String toString() {
        String s = "Total Ants: " + ants.size() + "\n";
        s += "Black ant ids: ";
        for (int i = 0; i < ants.size(); i++) {
            if (ants.get(i).getTeam() == TeamColour.BLACK) {
                s += ants.get(i).id + ", ";
            }
        }
        s += "\n";
        s += "Red ant ids: ";
        for (int i = 0; i < ants.size(); i++) {
            if (ants.get(i).getTeam() == TeamColour.RED) {
                s += ants.get(i).id + ", ";
            }
        }
        return s;
    }

    /**
     *
     * @return String representation of red ant coordinates
     */
    public String printRedPositions() {
        String s = "Red Ant Positions: ";
        for (int i = 0; i < ants.size(); i++) {
            if (ants.get(i).getTeam() == TeamColour.RED) {
                s += ants.get(i).id + "-pos:" + ants.get(i).position + " ";
            }
        }
        return s;
    }

    /**
     *
     * @return String representation of black ant coordinates
     */
    public String printBlackPositions() {
        String s = "Black Ant Positions: ";
        for (int i = 0; i < ants.size(); i++) {
            if (ants.get(i).getTeam() == TeamColour.BLACK) {
                s += ants.get(i).id + "-pos:" + ants.get(i).position + " ";
            }
        }
        return s;
    }

    private void drawHexGridLoop(Graphics g, Point origin, int size, int radius, int padding, WorldBuilder map) {
        double ang30 = Math.toRadians(30);
        double xOff = Math.cos(ang30) * (radius + padding);
        double yOff = Math.sin(ang30) * (radius + padding);
        int half = size / 2;

        for (int row = 0; row < map.getYSize(); row++) {
            int cols = map.getXSize();// - java.lang.Math.abs(row - half);
            if (row % 2 != 0) { // if even do this
                for (int col = 0; col < cols; col++) {
                    int x = (int) (origin.x + xOff * (col * 2 + 1 - cols));
                    int y = (int) (origin.y + yOff * (row - half) * 3);

                    Cell cellToCheck = worldMap.get(new Coordinate(col, row));

                    if (cellToCheck instanceof RockyCell) {
                        drawHex(g, 0, 0, x, y, radius, 0x510000);
                    } else if (cellToCheck instanceof RedCell) {
                        drawHex(g, 0, 0, x, y, radius, 0x992f26);
                    } else if (cellToCheck instanceof BlackCell) {
                        drawHex(g, 0, 0, x, y, radius, 0x7C7373);
                    } else if (cellToCheck.getFood() > 0 && cellToCheck instanceof ClearCell) {
                        drawHex(g, 0, 0, x, y, radius, 0x008844);
                    } else {
                        drawHex(g, 0, 0, x, y, radius, 0xFFFFFF);
                    }

                    if (cellToCheck.getAntPresent()) {
                        Ant antToCheck = ants.get(cellToCheck.getAntId());
                        if (antToCheck.getTeam().equals(TeamColour.RED)) {
                            drawHex(g, 0, 0, x, y, radius / 2, 0xDB4437);
                        } else {
                            drawHex(g, 0, 0, x, y, radius / 2, 0x3e3939);
                        }
                    }
                }
            } else { // if odd draw this
                for (int col = 0; col < cols; col++) { // offset to the left
                    int x = (int) (origin.x + xOff * (col * 2 + 1 - cols));
                    int y = (int) (origin.y + yOff * (row - half) * 3);

                    Cell cellToCheck = worldMap.get(new Coordinate(col, row));

                    if (cellToCheck instanceof RockyCell) {
                        drawHex(g, 0, 0, x - radius, y, radius, 0x510000);
                    } else if (cellToCheck instanceof RedCell) {
                        drawHex(g, 0, 0, x - radius, y, radius, 0x992f26);
                    } else if (cellToCheck instanceof BlackCell) {
                        drawHex(g, 0, 0, x - radius, y, radius, 0x7C7373);
                    } else if (cellToCheck.getFood() > 0 && cellToCheck instanceof ClearCell) {
                        drawHex(g, 0, 0, x - radius, y, radius, 0x008844);
                    } else {
                        drawHex(g, 0, 0, x - radius, y, radius, 0xFFFFFF);
                    }

                    if (cellToCheck.getAntPresent()) {
                        Ant antToCheck = ants.get(cellToCheck.getAntId());
                        if (antToCheck.getTeam().equals(TeamColour.RED)) {
                            drawHex(g, 0, 0, x - radius, y, radius / 2, 0xDB4437);
                        } else {
                            drawHex(g, 0, 0, x - radius, y, radius / 2, 0x3e3939);
                        }

                    }

                }
            }
        }
    }

    public void drawHex(Graphics g, int posX, int posY, int x, int y, int r, int color) {
        Graphics2D g2d = (Graphics2D) g;

        Hexagon hex = new Hexagon(x, y, r);

        Graphics2D hexCol = hex.draw(g2d, x, y, 0, color, true);
        //hex.draw(g2d, x, y, 2, 0x000000, false);

        g.setColor(new Color(0xFFFFFF));
        //g.drawString(text, x - w / 2, y + h / 2);
    }
    
    private void checkFood(WorldBuilder map, JLabel scoreLabel) {
        for (int i = 0; i <= map.getXSize(); i++) {
            for (int j = 0; j <= map.getYSize(); j++) {
                Cell toCheck = worldMap.get(new Coordinate(i, j));
                if (toCheck instanceof RedCell) {
                    redScore += toCheck.getFood();
                } else if (toCheck instanceof BlackCell) {
                    blackScore += toCheck.getFood();
                }
            }
        }
        scoreLabel.setText("Red Score: " + redScore + "          Black Score: " + blackScore);
    }
}
