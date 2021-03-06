/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AntGame;

import AntGame.Game.*;
import AntGame.drawing.DrawingPanel;
import java.awt.Container;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author tw242
 */
public class GameGUI extends javax.swing.JFrame {

    File brain1 = new File(""), brain2 = new File(""), world = new File(""), tournyBrain = new File("");
    boolean brain1Valid, brain2Valid, worldValid;
    String playerListString;
    GameSim game;
    ArrayList<Player> tournyPlayers = new ArrayList();

    /**
     * Creates new form Game
     */
    public GameGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        singleGameSetup = new javax.swing.JFrame();
        pickBrain1 = new javax.swing.JButton();
        pickBrain2 = new javax.swing.JButton();
        brain1Path = new javax.swing.JLabel();
        brain2Path = new javax.swing.JLabel();
        pickWorld = new javax.swing.JButton();
        randWorld = new javax.swing.JButton();
        worldStatus = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        tournamentSetup = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        playerList = new javax.swing.JTextArea();
        addPlayer = new javax.swing.JButton();
        brainChooser = new javax.swing.JButton();
        tournyBrainpath = new javax.swing.JLabel();
        playerNameField = new javax.swing.JTextField();
        startTournyButton = new javax.swing.JButton();
        roundCounter = new javax.swing.JLabel();
        roundNameLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        singleGameButton = new javax.swing.JButton();
        tournamentButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        singleGameSetup.setMinimumSize(new java.awt.Dimension(620, 240));

        pickBrain1.setText("Pick Brain 1");
        pickBrain1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickBrain1ActionPerformed(evt);
            }
        });

        pickBrain2.setText("Pick Brain 2");
        pickBrain2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickBrain2ActionPerformed(evt);
            }
        });

        brain1Path.setText("Please choose an ant brain!");

        brain2Path.setText("Please choose an ant brain!");

        pickWorld.setText("Pick World");
        pickWorld.setMaximumSize(new java.awt.Dimension(103, 23));
        pickWorld.setMinimumSize(new java.awt.Dimension(103, 23));
        pickWorld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickWorldActionPerformed(evt);
            }
        });

        randWorld.setText("Random World");
        randWorld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randWorldActionPerformed(evt);
            }
        });

        worldStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        worldStatus.setText("Please choose a game world!");

        jButton3.setText("Play");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout singleGameSetupLayout = new javax.swing.GroupLayout(singleGameSetup.getContentPane());
        singleGameSetup.getContentPane().setLayout(singleGameSetupLayout);
        singleGameSetupLayout.setHorizontalGroup(
            singleGameSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(singleGameSetupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(singleGameSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(worldStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(singleGameSetupLayout.createSequentialGroup()
                        .addComponent(pickBrain1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(brain1Path, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(singleGameSetupLayout.createSequentialGroup()
                        .addComponent(pickBrain2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(brain2Path, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
                    .addGroup(singleGameSetupLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(singleGameSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(singleGameSetupLayout.createSequentialGroup()
                                .addComponent(pickWorld, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(randWorld)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        singleGameSetupLayout.setVerticalGroup(
            singleGameSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(singleGameSetupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(singleGameSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(brain1Path, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pickBrain1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(singleGameSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pickBrain2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(brain2Path, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(singleGameSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pickWorld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(randWorld))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(worldStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        tournamentSetup.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        tournamentSetup.setMinimumSize(new java.awt.Dimension(673, 591));

        playerList.setColumns(20);
        playerList.setRows(5);
        playerList.setEnabled(false);
        jScrollPane2.setViewportView(playerList);

        addPlayer.setText("Add Player");
        addPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlayerActionPerformed(evt);
            }
        });

        brainChooser.setText("Choose Brain");
        brainChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brainChooserActionPerformed(evt);
            }
        });

        tournyBrainpath.setText("Choose a brain.");

        playerNameField.setText("Enter a name");
        playerNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerNameFieldActionPerformed(evt);
            }
        });

        startTournyButton.setText("Start Tournament");
        startTournyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startTournyButtonActionPerformed(evt);
            }
        });

        roundCounter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roundCounter.setText("Current Game: Round 0/300000");

        roundNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roundNameLabel.setText("N/A Vs. N/A");

        scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout tournamentSetupLayout = new javax.swing.GroupLayout(tournamentSetup.getContentPane());
        tournamentSetup.getContentPane().setLayout(tournamentSetupLayout);
        tournamentSetupLayout.setHorizontalGroup(
            tournamentSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tournamentSetupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tournamentSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tournamentSetupLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(startTournyButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(roundCounter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(tournamentSetupLayout.createSequentialGroup()
                        .addComponent(playerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addComponent(brainChooser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tournyBrainpath, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addPlayer)))
                .addContainerGap())
        );
        tournamentSetupLayout.setVerticalGroup(
            tournamentSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tournamentSetupLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(tournamentSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPlayer)
                    .addComponent(brainChooser)
                    .addComponent(tournyBrainpath)
                    .addComponent(playerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startTournyButton)
                .addGap(3, 3, 3)
                .addComponent(roundNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundCounter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scoreLabel)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ant Game");
        setMinimumSize(new java.awt.Dimension(339, 385));

        singleGameButton.setText("Single Game");
        singleGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleGameButtonActionPerformed(evt);
            }
        });

        tournamentButton.setText("Tournament");
        tournamentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tournamentButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AntGame/logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tournamentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(singleGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(singleGameButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(tournamentButton)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void singleGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleGameButtonActionPerformed

        singleGameSetup.setVisible(true);
        singleGameSetup.setLocationRelativeTo(this);

    }//GEN-LAST:event_singleGameButtonActionPerformed

    private void pickBrain1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickBrain1ActionPerformed
        final JFileChooser fc = new JFileChooser();

        File dir = new File("src");
        fc.setCurrentDirectory(dir);
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Ant Brains (.brain)", "brain"));
        fc.setAcceptAllFileFilterUsed(false);

        try {
            brain1 = loadBrainFile(fc);
            brain1Path.setText(brain1.toString());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(singleGameSetup,
                    "Please select an ant brain.",
                    "No brain selected",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pickBrain1ActionPerformed

    private void pickBrain2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickBrain2ActionPerformed
        final JFileChooser fc = new JFileChooser();

        File dir = new File("src");
        fc.setCurrentDirectory(dir);
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Ant Brains (.brain)", "brain"));
        fc.setAcceptAllFileFilterUsed(false);

        try {
            brain2 = loadBrainFile(fc);
            brain2Path.setText(brain2.toString());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(singleGameSetup,
                    "Please select an ant brain.",
                    "No brain selected",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pickBrain2ActionPerformed

    private void randWorldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randWorldActionPerformed
        worldStatus.setText("Using a random map.");
        try {
            WorldFileGeneratorGood wfg = new WorldFileGeneratorGood();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        world = new File("src\\randWorld.world");
    }//GEN-LAST:event_randWorldActionPerformed

    private void pickWorldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickWorldActionPerformed
        JFileChooser fc = new JFileChooser();

        File dir = new File("src");
        fc.setCurrentDirectory(dir);
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Ant Worlds (.world)", "world"));
        fc.setAcceptAllFileFilterUsed(false);

        try {
            world = loadWorldFile(fc);
            worldStatus.setText(world.toString());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(singleGameSetup,
                    "Please select an ant world.",
                    "No world selected",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pickWorldActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!brain1.toString().endsWith(".brain")) {
            brain1Valid = false;
            System.out.println("Choose a valid file for brain 1");
        } else {
            brain1Valid = true;
        }

        if (!brain2.toString().endsWith(".brain")) {
            brain2Valid = false;
            System.out.println("Choose a valid file for brain 2");
        } else {
            brain2Valid = true;
        }

        if (!world.toString().endsWith(".world")) {
            System.out.println("invalid file for the world. Using a random world!");
            worldValid = false;
        } else {
            worldValid = true;
        }

        if (brain1Valid && brain2Valid && worldValid) {
            System.out.println("We can play a game now :D");
            try {
                WorldBuilder wb = new WorldBuilder(world.toString());
                BrainMaker redBrain = new BrainMaker(brain1.toString());
                BrainMaker blackBrain = new BrainMaker(brain2.toString());

                GameSim game = new GameSim(redBrain.brain, blackBrain.brain, wb);
                game.runGame(wb);

                singleGameSetup.setVisible(false);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidBrainException ex) {
                Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tournamentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tournamentButtonActionPerformed
        tournamentSetup.setVisible(true);
        tournamentSetup.setLocationRelativeTo(this);
    }//GEN-LAST:event_tournamentButtonActionPerformed

    private void addPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlayerActionPerformed
        if (!tournyBrainpath.getText().endsWith(".brain")) {
            System.out.println("You dun goofed.");
        } else {
            try {
                BrainMaker brain = new BrainMaker(tournyBrain.toString());
                tournyPlayers.add(new Player(brain.brain, playerNameField.getText(), tournyBrainpath.getText()));
                playerListString = "";

                for (Player player : tournyPlayers) {
                    String brainString;
                    if (player.getPlayerName().length() < 8) {
                        brainString = "\t\tBrain: ";
                    } else {
                        brainString = "\tBrain: ";
                    }
                    playerListString += "Name: " + player.getPlayerName() + brainString + player.getBrainPathName()
                            + "\tGames Won: " + player.getGamesWon() + "\n";
                }

                playerList.setText(playerListString);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidBrainException ex) {
                Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addPlayerActionPerformed

    private void brainChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brainChooserActionPerformed
        final JFileChooser fc = new JFileChooser();

        File dir = new File("src");
        fc.setCurrentDirectory(dir);
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Ant Brains (.brain)", "brain"));
        fc.setAcceptAllFileFilterUsed(false);

        try {
            tournyBrain = loadBrainFile(fc);
            String[] tPath = tournyBrain.toString().split("\\\\");
            tournyBrainpath.setText(tPath[tPath.length - 1]);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(singleGameSetup,
                    "Please select an ant brain.",
                    "No brain selected",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_brainChooserActionPerformed

    private void playerNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playerNameFieldActionPerformed

    private void startTournyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startTournyButtonActionPerformed
 

        if (tournyPlayers.size() < 2) {
            JOptionPane.showMessageDialog(singleGameSetup,
                    "A tournament needs at least 2 players to start!",
                    "Add more players.",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            try {
            WorldFileGeneratorGood wfg = new WorldFileGeneratorGood();
            world = new File("src\\randWorld.world");
            WorldBuilder wb = new WorldBuilder(world.toString());
            final Tournament tourny = new Tournament(tournyPlayers, wb, playerList, tournamentSetup, roundCounter, roundNameLabel, scoreLabel);
//                tourny.playTournament();


            SwingWorker tournyPlayer = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
//                WorldFileGeneratorGood wfg = new WorldFileGeneratorGood();
//                world = new File("src\\randWorld.world");
//                WorldBuilder wb = new WorldBuilder(world.toString());
//                final Tournament tourny = new Tournament(tournyPlayers, wb, playerList, tournamentSetup);
                    tourny.playTournament();
                    return null;
                }
            };
            
            tournyPlayer.execute();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }//GEN-LAST:event_startTournyButtonActionPerformed

    private File loadBrainFile(JFileChooser fc) throws FileNotFoundException, IOException {
        int retVal = fc.showDialog(this, "Load Brain"); // 1 = null, 0 = chosen
        if (retVal == 1) { // then throw an error
            throw new FileNotFoundException();
        } else {
            try {
                BrainValidator.validateBrain(fc.getSelectedFile().toString());
            } catch (InvalidBrainException ex) {
                JOptionPane.showMessageDialog(singleGameSetup,
                        "This ant brain is invalid!",
                        "Invalid ant brain!",
                        JOptionPane.ERROR_MESSAGE);
            }

            return fc.getSelectedFile();
        }
    }

    /**
     *
     * @param fc
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    private File loadWorldFile(JFileChooser fc) throws FileNotFoundException, IOException {
        int retVal = fc.showDialog(this, "Load World"); // 1 = null, 0 = chosen
        if (retVal == 1) { // then throw an error
            throw new FileNotFoundException();
        } else {
            if (WorldValidator.validateWorld(fc.getSelectedFile().toString())) {
                System.out.println("The world is valid");
            } else {
                JOptionPane.showMessageDialog(singleGameSetup,
                        "This ant world is invalid!",
                        "Invalid ant world!",
                        JOptionPane.ERROR_MESSAGE);
            }

            return fc.getSelectedFile();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GameGUI game = new GameGUI();
                game.addKeyListener(new KeyEventClass());
                game.setLocationRelativeTo(null);
                game.setVisible(true);
                game.setResizable(false);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPlayer;
    private javax.swing.JLabel brain1Path;
    private javax.swing.JLabel brain2Path;
    private javax.swing.JButton brainChooser;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton pickBrain1;
    private javax.swing.JButton pickBrain2;
    private javax.swing.JButton pickWorld;
    private javax.swing.JTextArea playerList;
    private javax.swing.JTextField playerNameField;
    private javax.swing.JButton randWorld;
    private javax.swing.JLabel roundCounter;
    private javax.swing.JLabel roundNameLabel;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JButton singleGameButton;
    private javax.swing.JFrame singleGameSetup;
    private javax.swing.JButton startTournyButton;
    private javax.swing.JButton tournamentButton;
    private javax.swing.JFrame tournamentSetup;
    private javax.swing.JLabel tournyBrainpath;
    private javax.swing.JLabel worldStatus;
    // End of variables declaration//GEN-END:variables
}
