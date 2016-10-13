

import org.newdawn.slick.SlickException;


/**
 * 
 */
public class Sword extends Item implements Interactable
{
	/**
     * 
     */
    private int damageBoost;

    /**
     * Default constructor
     */
    public Sword() 
    throws SlickException
    {
    	super(Constant.SWORD_X, Constant.SWORD_Y, Constant.SWORD_PATH, Constant.SWORD);
    	damageBoost = Constant.SWORD_BOOST;
    }

    

    public void action(Interactable other) 
    {
        if(other.identify() == InteractorTag.Player)
        {
        	
        	((Player)other).takeItem(this);
        	((Player)other).setMaxDamage(((Player)other).getMaxDamage() + damageBoost);
        	
        }
    }



}