


import org.newdawn.slick.SlickException;

/**
 * 
 */
public class Amulet extends Item implements Interactable
{
	/**
     * 
     */
    private int hpBoost;

    /**
     * Default constructor
     */
    public Amulet() 
    throws SlickException
    {
    	super(Constant.AMULET_X, Constant.AMULET_Y, Constant.AMULET_PATH, Constant.AMULET);
    	hpBoost = Constant.AMULET_BOOST;
    }

    public void action(Interactable other) 
    {
        if (this.isInteractor(other))
        {
        	Player collector = (Player)other;
        	collector.setMaxHP(collector.getMaxHP() 
        			+ hpBoost);
        	collector.setHP(collector.getHP() + hpBoost);
        }
    }

	public Class<? extends Entity> getTag() 
	{
		// TODO Auto-generated method stub
		return this.getClass();
	}

}