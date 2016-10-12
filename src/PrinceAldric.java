
import java.util.*;

import org.newdawn.slick.Graphics;
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
    
    public void action()
    {
    	String []Dialog = this.getDialog();
    	
    	
    }
}