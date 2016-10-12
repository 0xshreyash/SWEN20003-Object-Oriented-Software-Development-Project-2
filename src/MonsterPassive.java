
import java.util.*;

/**
 * 
 */
public class MonsterPassive extends Monster {

    /**
     * Default constructor
     */
    public MonsterPassive() {
    }

    /**
     * @param map 
     * @param player 
     * @param delta 
     * @return
     */
    public void update(Map map, Player player, int delta) {
        // TODO implement here
        return null;
    }

    /**
     * @param g 
     * @return
     */
    public void render(Graphics g) {
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
     * @param map 
     * @param interactables 
     * @param delta 
     * @return
     */
    public abstract void update(Map map, ArrayList<Interactable> interactables, int delta);

}