/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import AntGame.Game.BrainMaker;
import AntGame.Game.GameSim;
import AntGame.Game.Instruction;
import AntGame.Game.InvalidBrainException;
import AntGame.Game.WorldBuilder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
public class GameSimTests {

    GameSim g;
    BrainMaker bm;
    WorldBuilder wb;

    public GameSimTests() throws IOException, FileNotFoundException, InvalidBrainException {

        ArrayList<Instruction> redAntBrain = new ArrayList();
        ArrayList<Instruction> blackAntBrain = new ArrayList();
        this.wb = new WorldBuilder("C:\\Users\\James\\Documents\\GitHub\\09042015\\JetGame\\AntGui\\Coursework\\JavaApplication31\\src\\1.world");
        BrainMaker bm = new BrainMaker("C:\\Users\\James\\Documents\\GitHub\\09042015\\JetGame\\AntGui\\Coursework\\JavaApplication31\\src\\brain1.brain");
        this.g = new GameSim(bm.brain, bm.brain, wb);
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
    public void gameSimTests() {
        Assert.assertEquals("Total Ants: 254\n" +
"Black ant ids: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, \n" +
"Red ant ids: 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, ", g.toString());        
        Assert.assertEquals("Black Ant Positions: 0-pos:137,65 1-pos:100,66 2-pos:101,67 3-pos:132,63 4-pos:138,64 5-pos:138,65 6-pos:101,66 7-pos:102,67 8-pos:103,68 9-pos:104,69 10-pos:132,61 11-pos:132,62 12-pos:133,63 13-pos:139,64 14-pos:139,65 15-pos:102,66 16-pos:103,67 17-pos:104,68 18-pos:105,69 19-pos:106,70 20-pos:141,71 21-pos:82,60 22-pos:133,61 23-pos:133,62 24-pos:134,63 25-pos:140,64 26-pos:140,65 27-pos:103,66 28-pos:104,67 29-pos:105,68 30-pos:106,69 31-pos:107,70 32-pos:142,71 33-pos:142,72 34-pos:83,60 35-pos:134,61 36-pos:134,62 37-pos:135,63 38-pos:141,64 39-pos:141,65 40-pos:104,66 41-pos:105,67 42-pos:106,68 43-pos:107,69 44-pos:108,70 45-pos:143,71 46-pos:143,72 47-pos:84,60 48-pos:135,61 49-pos:135,62 50-pos:136,63 51-pos:142,64 52-pos:142,65 53-pos:105,66 54-pos:106,67 55-pos:107,68 56-pos:108,69 57-pos:109,70 58-pos:144,71 59-pos:144,72 60-pos:85,60 61-pos:136,61 62-pos:136,62 63-pos:137,63 64-pos:143,64 65-pos:143,65 66-pos:106,66 67-pos:107,67 68-pos:108,68 69-pos:109,69 70-pos:110,70 71-pos:145,71 72-pos:145,72 73-pos:86,60 74-pos:137,61 75-pos:137,62 76-pos:138,63 77-pos:144,64 78-pos:144,65 79-pos:107,66 80-pos:108,67 81-pos:109,68 82-pos:110,69 83-pos:111,70 84-pos:146,71 85-pos:146,72 86-pos:87,60 87-pos:138,61 88-pos:138,62 89-pos:139,63 90-pos:145,64 91-pos:145,65 92-pos:108,66 93-pos:109,67 94-pos:110,68 95-pos:111,69 96-pos:112,70 97-pos:147,71 98-pos:147,72 99-pos:88,60 100-pos:139,61 101-pos:139,62 102-pos:140,63 103-pos:146,64 104-pos:146,65 105-pos:109,66 106-pos:110,67 107-pos:111,68 108-pos:112,69 109-pos:113,70 110-pos:148,71 111-pos:148,72 112-pos:140,62 113-pos:141,63 114-pos:147,64 115-pos:147,65 116-pos:110,66 117-pos:111,67 118-pos:112,68 119-pos:113,69 120-pos:114,70 121-pos:148,64 122-pos:148,65 123-pos:111,66 124-pos:112,67 125-pos:113,68 126-pos:112,66 ", g.printBlackPositions());
        Assert.assertEquals("Red Ant Positions: 127-pos:84,57 128-pos:138,55 129-pos:85,56 130-pos:85,57 131-pos:86,58 132-pos:87,59 133-pos:140,53 134-pos:139,54 135-pos:139,55 136-pos:86,56 137-pos:86,57 138-pos:87,58 139-pos:88,59 140-pos:89,60 141-pos:140,61 142-pos:142,51 143-pos:141,52 144-pos:141,53 145-pos:140,54 146-pos:140,55 147-pos:87,56 148-pos:87,57 149-pos:88,58 150-pos:89,59 151-pos:90,60 152-pos:141,61 153-pos:141,62 154-pos:142,63 155-pos:143,51 156-pos:142,52 157-pos:142,53 158-pos:141,54 159-pos:141,55 160-pos:88,56 161-pos:88,57 162-pos:89,58 163-pos:90,59 164-pos:91,60 165-pos:142,61 166-pos:142,62 167-pos:143,63 168-pos:144,51 169-pos:143,52 170-pos:143,53 171-pos:142,54 172-pos:142,55 173-pos:89,56 174-pos:89,57 175-pos:90,58 176-pos:91,59 177-pos:92,60 178-pos:143,61 179-pos:143,62 180-pos:144,63 181-pos:145,51 182-pos:144,52 183-pos:144,53 184-pos:143,54 185-pos:143,55 186-pos:90,56 187-pos:90,57 188-pos:91,58 189-pos:92,59 190-pos:93,60 191-pos:144,61 192-pos:144,62 193-pos:145,63 194-pos:146,51 195-pos:145,52 196-pos:145,53 197-pos:144,54 198-pos:144,55 199-pos:91,56 200-pos:91,57 201-pos:92,58 202-pos:93,59 203-pos:94,60 204-pos:145,61 205-pos:145,62 206-pos:146,63 207-pos:147,51 208-pos:146,52 209-pos:146,53 210-pos:145,54 211-pos:145,55 212-pos:92,56 213-pos:92,57 214-pos:93,58 215-pos:94,59 216-pos:95,60 217-pos:146,61 218-pos:146,62 219-pos:147,63 220-pos:148,51 221-pos:147,52 222-pos:147,53 223-pos:146,54 224-pos:146,55 225-pos:93,56 226-pos:93,57 227-pos:94,58 228-pos:95,59 229-pos:96,60 230-pos:147,61 231-pos:147,62 232-pos:148,63 233-pos:148,52 234-pos:148,53 235-pos:147,54 236-pos:147,55 237-pos:94,56 238-pos:94,57 239-pos:95,58 240-pos:96,59 241-pos:97,60 242-pos:148,61 243-pos:148,62 244-pos:148,54 245-pos:148,55 246-pos:95,56 247-pos:95,57 248-pos:96,58 249-pos:97,59 250-pos:98,60 251-pos:96,56 252-pos:96,57 253-pos:97,58 ", g.printRedPositions());
    }

}
