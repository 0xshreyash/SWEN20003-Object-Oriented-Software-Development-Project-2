

import org.newdawn.slick.SlickException;

/**
 * 
 */
public class Sword extends Item implements Interactable
{
	/**
     * 
     */
    private int damageBoost;

    /**
     * Default constructor
     */
    public Sword() 
    throws SlickException
    {
    	super(Constant.SWORD_X, Constant.SWORD_Y, Constant.SWORD_PATH, Constant.SWORD);
    	damageBoost = Constant.SWORD_BOOST;
    }

    

    /**
     * @param otherObj 
     * @return
     */
    public void action(Interactable other) 
    {
        if (this.isInteractor(other))
        {
        	Player collector = (Player)other;
        	collector.setMaxDamage(collector.getMaxDamage() 
        			+ damageBoost);
        }
    }



	
	public Class<? extends Entity> getTag() {
		// TODO Auto-generated method stub
		return this.getClass();
	}




}