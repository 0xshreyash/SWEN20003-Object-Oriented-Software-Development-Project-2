
import java.util.*;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * 
 */
public class Garth extends Villager implements Interactable
{

    /**
     * Default constructor
     */
    public Garth() 
    throws SlickException
    {
    		super(Constant.PEASANT_PATH, Constant.GarthX, Constant.GarthY,
    		 Constant.GarthSays, Constant.PEASANT);
    }
    
    public void action()
    {
    	String []Dialog = this.getDialog();
    	
    }

    public Class<? extends Entity> getTag()
    {
    	return this.getClass();
    	
    }

	
	public void action(Interactable other)
	{
		
	}
}