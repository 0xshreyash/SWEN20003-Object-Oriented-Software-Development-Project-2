


import org.newdawn.slick.SlickException;


/**
 * 
 */
public class Amulet extends Item implements Interactable
{
	/**
     * 
     */
    private int hpBoost;

    /**
     * Default constructor
     */
    public Amulet() 
    throws SlickException
    {
    	super(Constant.AMULET_X, Constant.AMULET_Y, Constant.AMULET_PATH, Constant.AMULET);
    	hpBoost = Constant.AMULET_BOOST;
    }

    public void action(Interactable other) 
    {
        if(other.identify() == InteractorTag.Player)
        {
        	
        	((Player)other).takeItem(this);
        	((Player)other).setMaxHP(((Player)other).getMaxHP() + hpBoost);
        	((Player)other).setHP(((Player)other).getHP() + hpBoost);
        	
        }
    }


}