/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import AntGame.Game.Cell;
import AntGame.Game.Coordinate;
import AntGame.Game.WorldBuilder;
import java.io.IOException;
import java.util.HashMap;
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
public class WorldBuilderTests {
    WorldBuilder wb;
    public WorldBuilderTests() throws IOException {
        wb = new WorldBuilder("C:\\Users\\James\\Documents\\GitHub\\09042015\\JetGame\\AntGui\\Coursework\\JavaApplication31\\src\\1.world");
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
    public void worldBuilderTests(){
        HashMap<Coordinate, Cell> m = wb.getWorld();
        //char one = m.get(new Coordinate(0,0));
        Assert.assertEquals(m.get(new Coordinate(0,0)).toString(),"#");
        Assert.assertEquals(m.get(new Coordinate(5,5)).toString(),".");
        Assert.assertEquals(m.get(new Coordinate(17,27)).toString(),"5");
        Assert.assertEquals(m.get(new Coordinate(38,70)).toString(),"-");        
        Assert.assertEquals(m.get(new Coordinate(80,60)).toString(),"+");                
        Assert.assertEquals(wb.getXSize(),150);
        Assert.assertEquals(wb.getYSize(),150);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
