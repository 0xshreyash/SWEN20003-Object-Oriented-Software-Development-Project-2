
import java.util.*;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import Interactable.InteractorTag;

/**
 * 
 */
public class PrinceAldric extends Villager
{

    /**
     * Default constructor
     */
    public PrinceAldric() 
    throws SlickException
    {
    		super(Constant.PRINCE_PATH, Constant.PrinceX, Constant.PrinceY,
    		 Constant.AldricSays, Constant.PRINCE);
    }
    
    @Override
	public void action(Interactable other) 
	{
		if(other.identify() == InteractorTag.Player && talk == false)
		{
			if(((Player)other).isTalking())
			{
				talkTo((Player)other);
			}
			
		}
		
	}

    public Class<? extends Entity> getTag()
    {
    	return this.getClass();
    	
    }

	

	
	
}