/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import AntGame.Game.WorldValidator;
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
public class WorldValidatorTests {
    WorldValidator wv;
    public WorldValidatorTests() {        
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
    public void worldValidatorTests() throws IOException{    
        wv = new WorldValidator();     
        Assert.assertEquals(false,wv.validateWorld("C:\\Users\\James\\Documents\\GitHub\\09042015\\JetGame\\AntGui\\Coursework\\JavaApplication31\\src\\invalidBorder.world"));
        Assert.assertEquals(false,wv.validateWorld("C:\\Users\\James\\Documents\\GitHub\\09042015\\JetGame\\AntGui\\Coursework\\JavaApplication31\\src\\invalidInterior.world"));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
