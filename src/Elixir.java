


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
     * @param otherObj 
     * @return
     */
    public void action(Interactable other) 
    {
        return;
    }


	public Class<? extends Entity> getTag() 
	{
		// TODO Auto-generated method stub
		return this.getClass();
	}




}