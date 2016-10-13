


import org.newdawn.slick.SlickException;

/**
 * 
 */
public class Elixir extends Item implements Interactable
{
	/**
     * 
     */


    /**
     * Default constructor
     */
    public Elixir() 
    throws SlickException
    {
    	super(Constant.ELIXIR_X, Constant.ELIXIR_Y, Constant.ELIXIR_PATH, Constant.ELIXIR);
    	
    }

    /**
     * @param other
     * @return
     */
    public void action(Interactable other) 
    {
        if(other.identify() == InteractorTag.Player)
        {
        	((Player)other).takeItem(this);
        	
        }
    }





}