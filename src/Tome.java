
import java.util.*;

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

    

    /**
     * @param otherObj 
     * @return
     */
    public void action(Interactable other) 
    {
        if (this.isInteractor(other))
        {
        	Player collector = (Player)other;
        	collector.setMaxCoolDown(collector.getMaxCoolDown() 
        		+ coolDownBoost );
        }
    }



	
	public Class<? extends Entity> getTag() {
		// TODO Auto-generated method stub
		return this.getClass();
	}




}