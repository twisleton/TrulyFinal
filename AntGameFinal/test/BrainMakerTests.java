/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import AntGame.Game.BrainMaker;
import AntGame.Game.InvalidBrainException;
import java.io.FileNotFoundException;
import java.io.IOException;
import junit.framework.Assert;
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
public class BrainMakerTests {

    BrainMaker bm;

    public BrainMakerTests() throws IOException, FileNotFoundException, InvalidBrainException {
        this.bm = new BrainMaker("C:\\Users\\James\\Documents\\GitHub\\09042015\\JetGame\\AntGui\\Coursework\\JavaApplication31\\src\\testBrain.brain");
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

    @Test
    public void loadBrain() {
        Assert.assertEquals(bm.brain.get(0).toString(), "Sense: Ahead, 1, 3, Food");
        Assert.assertEquals(bm.brain.get(2).toString(), "Mark: 0, 1");
        Assert.assertEquals(bm.brain.get(3).toString(), "Mark: 0, 1");
        Assert.assertEquals(bm.brain.get(4).toString(), "PickUp: 8, 0");
        Assert.assertEquals(bm.brain.get(1).toString(), "Move: 2, 0");
        Assert.assertEquals(bm.brain.get(12).toString(), "Drop: 0");
        Assert.assertEquals(bm.brain.get(6).toString(), "Turn: Right, 0");
        Assert.assertEquals(bm.brain.get(5).toString(), "Flip: 3, 4, 5");
                 
        Assert.assertEquals(bm.brain.get(18).toString(), "Sense: LeftAhead, 1, 3, Food");
        Assert.assertEquals(bm.brain.get(19).toString(), "Sense: RightAhead, 1, 3, Food");
        Assert.assertEquals(bm.brain.get(20).toString(), "Sense: Here, 1, 3, Food");
        
        Assert.assertEquals(bm.brain.get(21).toString(), "Sense: Here, 1, 3, Friend");
        Assert.assertEquals(bm.brain.get(22).toString(), "Sense: Here, 1, 3, Foe");
        Assert.assertEquals(bm.brain.get(23).toString(), "Sense: Here, 1, 3, FriendWithFood");
        Assert.assertEquals(bm.brain.get(24).toString(), "Sense: Here, 1, 3, FoeWithFood");
        Assert.assertEquals(bm.brain.get(25).toString(), "Sense: Here, 1, 3, Rock");
        Assert.assertEquals(bm.brain.get(26).toString(), "Sense: Here, 1, 3, FoeMarker");
        Assert.assertEquals(bm.brain.get(27).toString(), "Sense: Here, 1, 3, Home");
        Assert.assertEquals(bm.brain.get(28).toString(), "Sense: Here, 1, 3, FoeHome");
        
        
        
    }
    
    @Test
    public void senseDirFromString(){
        
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
