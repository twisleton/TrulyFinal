/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import AntGame.Game.BrainValidator;
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
public class BrainValidatorTests {

    BrainValidator bv;

    public BrainValidatorTests() {
        this.bv = new BrainValidator();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Test
    public void brainValidatorTests() {
        Assert.assertEquals(false, bv.validateLine("Sense Wow 0 1"));
        Assert.assertEquals(false, bv.validateLine("Sense Ahead 10000 1"));
        Assert.assertEquals(false, bv.validateLine("Sense Ahead 1 10000"));
        Assert.assertEquals(true, bv.validateLine("Sense Ahead 1 11 Foe"));
        Assert.assertEquals(false, bv.validateLine("Sense Ahead 1 11 Wow"));
        Assert.assertEquals(false, bv.validateLine("Mark 6 0"));
        Assert.assertEquals(false, bv.validateLine("Mark 0 10000"));
        Assert.assertEquals(false, bv.validateLine("PickUp 1 10000"));
        Assert.assertEquals(false, bv.validateLine("PickUp 100000 1"));
        Assert.assertEquals(false, bv.validateLine("Move 1 10000"));
        Assert.assertEquals(false, bv.validateLine("Move 10000 1"));
        Assert.assertEquals(false, bv.validateLine("Drop 10000"));
        Assert.assertEquals(false, bv.validateLine("Turn wow 1"));
        Assert.assertEquals(false, bv.validateLine("Turn Left 10000"));
        Assert.assertEquals(false, bv.validateLine("Turn Left 10000"));
        Assert.assertEquals(false, bv.validateLine("Flip 3 10000 13"));
        Assert.assertEquals(false, bv.validateLine("Flip 3 13 10000"));
        
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
