
import java.util.*;

import org.newdawn.slick.Graphics;
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
		if(this.isInteractor(other))
		{
			
			
		}
			
		
	}
}