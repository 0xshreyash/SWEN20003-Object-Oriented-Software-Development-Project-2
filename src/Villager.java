
import java.util.*;

/**
 * 
 */
public abstract class Villager extends Unit {

    /**
     * Default constructor
     */
    public Villager() {
    }

    /**
     * 
     */
    private String dialogue;

    /**
     * 
     */
    public String name;

    /**
     * @return
     */
    public void talk() {
        // TODO implement here
        return null;
    }

    /**
     * @param otherObj 
     * @return
     */
    public boolean withinRange(Interactable otherObj) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public interactors enum getInteractors() {
        // TODO implement here
        return null;
    }

    /**
     * @param otherObj 
     * @return
     */
    public void action(Interactable otherObj) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getName() {
        // TODO implement here
        return "";
    }

}