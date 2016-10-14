 
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public abstract  class Monster extends Unit implements Interactable
{
	/** Setting the instance variable of this calls first
	 */
	private boolean underAttack; 
	private float deltaSinceBeingAttacked;
	
	/** Current adversary */
	private Interactable adversary;
	
	/** Constructor for this class
	 * @param MonsterImagePath path of the monster's image
	 * @param starting_X starting x position
	 * @param starting_Y starting y position
	 * @param max_HP maximum hp of the monster
	 * @param monster_speed speed of the monster
	 * @param max_Damage max damage of the monster
	 * @param max_CoolDown max cooldown of the monster
	 * @param MonsterName name of the monster
	 * @throws SlickException 
	 */
	public Monster(String MonsterImagePath, float starting_X, float starting_Y,
			int max_HP, float monster_speed, int max_Damage, int max_CoolDown, String MonsterName)
    throws SlickException
    {
    	super(MonsterImagePath, starting_X, starting_Y,
    		max_HP, monster_speed, max_Damage,max_CoolDown, MonsterName);
    	underAttack = false;
    	adversary = null;
    	this.setCoolDown(0);
    }
    
	/** Getter of the adversary
	 * @return the adversary 
	 */
	public Interactable getAdversary() 
    {
		return adversary;
	}

	/** Setter of the adversary
	 * @param adversary
	 */
	public void setAdversary(Interactable adversary) 
	{
		this.adversary = adversary;
	}

	/** getter for the change in delta since the player was last attacked
	 * @return deltas
	 */
	public float getDeltaSinceBeingAttacked() 
    {
		return deltaSinceBeingAttacked;
	}

	/** Setter for the new delta wafter the player was attacked
	 * @param newDelta
	 */
	public void setDeltaSinceBeingAttacked(float newDelta) 
	{
		this.deltaSinceBeingAttacked = newDelta;
	}
	
	/** Checking if the player is under attack
	 * @return boolean if the player is attacked
	 */
    public boolean isUnderAttack() 
    {
		return underAttack;
	}

    /** Setter for the condition that if the player is attacked
     * @param underAttack
     */
	public void setUnderAttack(boolean underAttack) 
	{
		this.underAttack = underAttack;
	}
	
	
	/** 
	 * Draws the monster only if it is not dead
	 * @param g - Graphics container
	 */
	@Override
	public void render(Graphics g)
    {
    		
    	if(!this.isDead())	
    	{
    		this.getImage().drawCentered(this.getxPos(), this.getyPos());
    		this.getImageInverted().drawCentered(this.getxPos(), this.getyPos());
    		renderHealthBar(g);
    	}
    
    
    }
	
	/**
	 *  Checking whether a monster is alive or dead
	 * 
	 */
	@Override
	public boolean isActive() 
	{
		return this.getHP() >= 0;
	}
	
	/** Getting the distance of the monster form the other interactable
	 * @param other being the other interactable
	 * @return the distance
	 */
	public float getDistance(Interactable other)
	{
	    return (float)Math.sqrt((double)getPos().distanceSquared(other.getPos()));
	}
	
	
	/** 
	 * Checking whether an interactaable is within range of the monster
	 */
	@Override
	public boolean isWithinRange(Interactable other) 
	{
		return getDistance(other) <= Constant.COLLIDE_RANGE;
	}
	
	/** 
	 * Returns if the monster can follow another interactable 
	 * @param other - Interactable
	 * @return true if following is allowed
	 */
	public boolean canFollow(Interactable other)
	{
		return getDistance(other) <= Constant.FOLLOW_RANGE;
	}
    
   
    
    



}