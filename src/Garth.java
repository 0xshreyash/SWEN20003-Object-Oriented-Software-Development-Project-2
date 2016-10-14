
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