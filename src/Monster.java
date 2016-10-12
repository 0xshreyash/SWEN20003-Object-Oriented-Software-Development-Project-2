
import java.util.*;

/**
 * 
 */
public abstract class Monster extends Unit 
{

    

    public Monster() 
    {
    	
    }

    /**
     * 
     */
    private String name;

    /**
     * @param other
     * @return
     */
    public boolean withinRange(Interactable other) 
    {
        
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
     * @param map 
     * @param interactables 
     * @param delta 
     * @return
     */
    public abstract void update(Map map, ArrayList<Interactable> interactables, int delta);

    /**
     * @return
     */
    public String getName() {
        // TODO implement here
        return "";
    }

}