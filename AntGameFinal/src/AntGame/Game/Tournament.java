/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AntGame.Game;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 *
 * @author James
 */
public class Tournament {
    
    class LeaderBoardUpdater extends SwingWorker<Void, Void> {
       @Override
       public Void doInBackground() throws FileNotFoundException, IOException, InvalidBrainException {
//           for (int i = 0; i < players.size(); i++) {
//            for (int j = 0; j < players.size(); j++) {
//                if (i != j) {
//                    System.out.println(i + " vs. " + j);
//                    g = new GameSim(players.get(i).getBrain(), players.get(j).getBrain(), map);
//                    g.playGame(map, roundCounter, players.get(i), players.get(j));
//                    if (g.getWinner() == true) {
//                        players.get(i).incrementGamesWon();
//
//                        new LeaderBoardUpdater().doInBackground();
//                    } else {
//                        players.get(j).incrementGamesWon();
//                        
//                        new LeaderBoardUpdater().doInBackground();
//                    }
//                }
//            }
//
//        }
//
//        int maxWon = 0;
//        int maxWonPlayer = -1;
//        for (int i = 0; i < players.size(); i++) {
//            if (players.get(i).getGamesWon() > maxWon) {
//                maxWon = players.get(i).getGamesWon();
//                maxWonPlayer = i;
//            }
//        }
//        System.out.println("Player: " + maxWonPlayer + " Wins!");
           updateLeaderBoard();
        return null;
       }

       @Override
       protected void done() {
           try {
               updateLeaderBoard();
           } catch (Exception ignore) {
           }
       }
   }

    ArrayList<Player> players;
    WorldBuilder map;
    GameSim g;
    JTextArea leaderBoard;
    JFrame roundCounter;
    JLabel roundTicker, roundLabel, score;

    public Tournament(ArrayList<Player> players, WorldBuilder map, JTextArea scoreBoard, JFrame round, JLabel rCounter, JLabel roundNameLabel, JLabel scoreLabel) {
        this.players = players;
        this.map = map;
        leaderBoard = scoreBoard;
        roundCounter = round;
        roundTicker = rCounter;
        roundLabel = roundNameLabel;
        score = scoreLabel;
    }

    public Player playTournament() throws IOException, FileNotFoundException, InvalidBrainException {

        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < players.size(); j++) {
                if (i != j) {
                    System.out.println(players.get(i).playerName + " vs. " + players.get(j).playerName);
                    roundLabel.setText(players.get(i).playerName + " (Red) Vs. " + players.get(j).playerName +" (Black)");
                    g = new GameSim(players.get(i).getBrain(), players.get(j).getBrain(), map);
                    g.playGame(map, roundCounter, players.get(i), players.get(j), roundTicker, score);
                    if (g.getWinner() == true) {
                        players.get(i).incrementGamesWon();                        
                        new LeaderBoardUpdater().doInBackground();
                    } else {
                        players.get(j).incrementGamesWon();                        
                        new LeaderBoardUpdater().doInBackground();
                    }
                }
            }

        }

        int maxWon = 0;
        int maxWonPlayer = -1;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getGamesWon() > maxWon) {
                maxWon = players.get(i).getGamesWon();
                maxWonPlayer = i;
            }
        }
        
        System.out.println("Player: " + maxWonPlayer + " Wins!");
        JOptionPane.showMessageDialog(roundCounter,
                    players.get(maxWonPlayer).playerName + " Wins!"
                    );
        return players.get(maxWonPlayer);
        
        //LeaderBoardUpdater lbu = new LeaderBoardUpdater();
        //return lbu.doInBackground();
        
    }

    public void updateLeaderBoard() {
        String playerListString = "";

        for (Player player : players) {
            String brainString;
            if (player.getPlayerName().length() < 8) {
                brainString = "\t\tBrain: ";
            } else {
                brainString = "\tBrain: ";
            }
            playerListString += "Name: " + player.getPlayerName() + brainString + player.getBrainPathName()
                    + "\tGames Won: " + player.getGamesWon() + "\n";
        }

        leaderBoard.setText(playerListString);
    }
}
