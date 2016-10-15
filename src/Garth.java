/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 */


import org.newdawn.slick.SlickException;


/**
 * Garth is a villager that implements actions
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
    
    /** 
     * Choosing how to act on the other Interactable
     * @param other object of type Interactable
     */
    @Override
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
    
    /** Just sets up the dialogue for Garth depending on what the player has in the inventory
     * @param player is the current player object
     */
    public void talkTo(Player player)
    {
    	this.setTalk(true);
    	
    	if(!player.hasItem(Constant.AMULET))
    	{
    		this.setCurrentlySaying(dialogAtIndex(0));
    	}
    	else if(!player.hasItem(Constant.SWORD))
    	{
    		this.setCurrentlySaying(dialogAtIndex(1));
    	}
    	else if(!player.hasItem(Constant.TOME))
    	{
    		this.setCurrentlySaying(dialogAtIndex(2));
    	}
    	else
    	{
    		this.setCurrentlySaying(dialogAtIndex(3));
    	}
    	return;
    }
}