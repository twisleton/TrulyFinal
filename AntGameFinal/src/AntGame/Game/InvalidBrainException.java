package AntGame.Game;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tw242
 */
public class InvalidBrainException extends Exception {

    /**
     * Creates a new instance of
     * <code>InvalidBrainException</code> without detail message.
     */
    public InvalidBrainException() {
    }

    /**
     * Constructs an instance of
     * <code>InvalidBrainException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidBrainException(String msg) {
        super(msg);
    }
}
