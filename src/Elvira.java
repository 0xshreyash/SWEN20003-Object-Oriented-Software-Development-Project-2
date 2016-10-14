

import org.newdawn.slick.SlickException;


/**
 * 
 */
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
    
    @Override
    /** Action of Elvira, which is just dialogue
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