/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AntGame.Game;

/**
 *
 * @author tw242
 */
public class InvalidWorldException extends Exception {

    /**
     * Creates a new instance of
     * <code>InvalidWorldException</code> without detail message.
     */
    public InvalidWorldException() {
    }

    /**
     * Constructs an instance of
     * <code>InvalidWorldException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidWorldException(String msg) {
        super(msg);
    }
}
