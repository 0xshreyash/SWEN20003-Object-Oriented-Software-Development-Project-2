/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 */

import org.newdawn.slick.SlickException;

/** Shaman Elvira's class */
public class Elvira extends Villager implements Interactable
{

    /**
     * Default constructor
     */
    public Elvira() 
    throws SlickException
    {
    		super(Constant.SHAMAN_PATH, Constant.ElviraX, Constant.ElivraY,
    		 Constant.ElviraSays, Constant.SHAMAN);
    }
    
    
    /** Action of Elvira, which is just dialogue
     */
    @Override
	public void action(Interactable other) 
	{
    		/* Identify if it is the player */
		if(other.identify() == InteractorTag.Player && this.isTalking() == false)
		{
			if(((Player)other).isTalking())
			{
				talkTo((Player)other);
			}
			
		}
		
	}
    
    /** This method sets the HP of the player to full after the player talks to Elvira
     * @param player is the player object
     */
    public void talkTo(Player player)
    {
	    	this.setTalk(true);
	    	
	    	if(player.getHP() == player.getMaxHP())
	    	{
	    		this.setCurrentlySaying(dialogAtIndex(0));
	    	}
	    	else
	    	{
	    		player.setHP(player.getMaxHP());
	    		this.setCurrentlySaying(dialogAtIndex(1));
	    	}
    }
}