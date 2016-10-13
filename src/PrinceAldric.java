
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
    
    public void talkTo(Player player)
    {
    	this.setTalk(true);
    	
    	if (!player.hasItem(Constant.AMULET)) {
            activeLine = dialogues.get(0);
        } else if (!player.hasItem(Constants.SWORD)) {
            activeLine = dialogues.get(1);
        } else if (!player.hasItem(Constants.TOME)) {
            activeLine = dialogues.get(2);
        } else {
            activeLine = dialogues.get(3);
        }
    }
    
    
   

	

	
	
}