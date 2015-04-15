/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import AntGame.Game.BrainMaker;
import AntGame.Game.InvalidBrainException;
import AntGame.Game.Player;
import AntGame.Game.Tournament;
import AntGame.Game.WorldBuilder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author James
 */
public class TournamentTest {
    
    public TournamentTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void tournamentTest() throws IOException, FileNotFoundException, InvalidBrainException{
        BrainMaker b = new BrainMaker("C:\\Users\\James\\Documents\\GitHub\\09042015\\JetGame\\AntGui\\Coursework\\JavaApplication31\\src\\betterBrain.brain");
        BrainMaker b2 = new BrainMaker("C:\\Users\\James\\Documents\\GitHub\\09042015\\JetGame\\AntGui\\Coursework\\JavaApplication31\\src\\brain1.brain");
        WorldBuilder w = new WorldBuilder("C:\\Users\\James\\Documents\\GitHub\\09042015\\JetGame\\AntGui\\Coursework\\JavaApplication31\\src\\1.world");
        Player p1 = new Player(false,b.brain);
        Player p2 = new Player(false,b2.brain);
        Player p3 = new Player(false,b2.brain);
        Player p4 = new Player(false,b2.brain);
        
        ArrayList<Player> players = new ArrayList();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        Tournament t = new Tournament(players,w);        
        System.out.println((t.playTournament()));        
        
        
        //b.brain();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
