

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