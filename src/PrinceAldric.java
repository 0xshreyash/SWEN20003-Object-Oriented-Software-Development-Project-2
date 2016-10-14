/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 */

import org.newdawn.slick.SlickException;

/**
 * 
 */
public class PrinceAldric extends Villager implements Interactable
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
    /** Defining the action of the prince respect to another interactable
     */
	public void action(Interactable other) 
	{
		if(other.identify() == InteractorTag.Player && this.isTalking() == false)
		{
			if(((Player)other).isTalking())
			{
				talkTo((Player)other);
			}
			
		}
		
	}
    
    /** Talks to player and decides which dialogue to say
     * @param player
     */
    public void talkTo(Player player)
    {
    	this.setTalk(true);
    	
    	if(!player.hasItem(Constant.ELIXIR))
    	{
    		this.setCurrentlySaying(dialogAtIndex(0));
    	}
    	else
    	{
    		this.setCurrentlySaying(dialogAtIndex(1));
    		try 
    		{
				player.takeAwayItem(Constant.ELIXIR);
				
			} 
    		catch (SlickException e) 
    		{
				
				e.printStackTrace();
			}
    	}
    }
    
    
   

	

	
	
}