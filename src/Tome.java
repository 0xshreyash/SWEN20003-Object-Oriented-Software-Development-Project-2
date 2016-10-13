

import org.newdawn.slick.SlickException;

/**
 * 
 */
public class Tome extends Item implements Interactable
{
	/**
     * 
     */
	int coolDownBoost; 

    /**
     * Default constructor
     */
    public Tome() 
    throws SlickException
    {
    	super(Constant.TOME_X, Constant.TOME_Y, Constant.TOME_PATH, Constant.TOME);
    	coolDownBoost = Constant.TOME_BOOST;
    }

    
    public void action(Interactable other) 
    {
        if(other.identify() == InteractorTag.Player)
        {	
        	((Player)other).takeItem(this);
        	((Player)other).setMaxCoolDown(((Player)other).getMaxCoolDown() + coolDownBoost);
        		
        }
    }

}