package AntGame.Game;


/**
 * A catch all interface for all the instructions that an ant brain can use.
 *
 * @author Tom Wija
 */
public interface Instruction {

}

/**
 * Represents the Sense instruction.
 *
 * @author Tom Wija
 */
class Sense implements Instruction {
    SenseDir senseDir;
    int st1, st2;
    Cond cond;
    
    /**
     * 
     * @param senseDir Where to check condition
     * @param st1 state to go to if condition holds
     * @param st2 state to go to otherwise
     * @param cond condition to check
     */
    public Sense(SenseDir senseDir, int st1, int st2, Cond cond) {
        this.senseDir = senseDir;
        this.st1 = st1;
        this.st2 = st2;
        this.cond = cond;
    }
    
    @Override
    public String toString() {
        String s = "Sense: ";
        s += senseDir + ", ";
        s += st1 + ", ";
        s += st2 + ", ";
        s += cond;
        return s;
    }
}

/**
 * Represents the Mark instruction.
 *
 * @author Tom Wija
 */
class Mark implements Instruction {
    int i, st;
    
    /**
     * 
     * @param i marker to set in current cell
     * @param st state to go to after marking
     */
    public Mark(int i, int st) {
        this.i = i;
        this.st = st;
    }
    
    @Override
    public String toString() {
        String s = "Mark: ";
        s += i + ", ";
        s += st;
        return s;
    }
}

/**
 * Represents the Unmark instruction.
 *
 * @author Tom Wija
 */
class Unmark implements Instruction {
    int i, st;
    
    /**
     * 
     * @param i marker to unmark in current cell
     * @param st state to go to when finished
     */
    public Unmark(int i, int st) {
        this.i = i;
        this.st = st;
    }
    
    @Override
    public String toString() {
        String s = "Unmark: ";
        s += i + ", ";
        s += st;
        return s;
    }
}

/**
 * Represents the PickUp instruction.
 *
 * @author Tom Wija
 */
class PickUp implements Instruction {
    int st1, st2;
    
    /**
     * Pickup food in current cell.
     * @param st1 go to this state if there is food in the cell
     * @param st2 go to this state if there is no food in the cell
     */
    public PickUp(int st1, int st2) {
        this.st1 = st1;
        this.st2 = st2;
    }
    
    @Override
    public String toString() {
        String s = "PickUp: ";
        s += st1 + ", ";
        s += st2;
        return s;
    }
}

/**
 * Represents the Drop instruction.
 *
 * @author Tom Wija
 */
class Drop implements Instruction {
    int st;
    
    /**
     * Drop food in current cell. 
     * @param st state to go to after dropping food.
     */
    public Drop(int st) {
        this.st = st;
    }
    
    @Override
    public String toString() {
        String s = "Drop: ";
        s += st;
        return s;
    }
}

/**
 * Represents the Turn instruction.
 *
 * @author Tom Wija
 */
class Turn implements Instruction {
    LeftRight lr;
    int st;
    
    /**
     * Turn left or right then go to state st.
     * @param lr direction to turn
     * @param st state to go to when finished. 
     */
    public Turn(LeftRight lr, int st) {
        this.lr = lr;
        this.st = st;
    }
    
    @Override
    public String toString() {
        String s = "Turn: ";
        s += lr + ", ";
        s += st;
        return s;
    }
}

/**
 * Represents the Move instruction.
 *
 * @author Tom Wija
 */
class Move implements Instruction {
    int st1, st2;
    
    /**
     * Move forward and go to st1.
     * @param st1 state to go to if successful.
     * @param st2 state to go to if blocked. 
     */
    public Move(int st1, int st2) {
        this.st1 = st1;
        this.st2 = st2;
    }
    
    @Override
    public String toString() {
        String s = "Move: ";
        s += st1 + ", ";
        s += st2;
        return s;
    }
}

/**
 * Represents the Flip instruction.
 *
 * @author Tom Wija
 */
class Flip implements Instruction {
    int p, st1, st2;
    
    /**
     * Choose random number x between 0 and p-1. 
     * @param p upper limit.
     * @param st1 if x = 0, go to this state
     * @param st2 if x > 0, go to this state. 
     */
    public  Flip(int p, int st1, int st2) {
       this.p = p;
       this.st1 = st1;
       this.st2 = st2;
    }
    
    @Override
    public String toString() {
        String s = "Flip: ";
        s += p + ", ";
        s += st1 + ", ";
        s += st2;
        return s;
    }
}
