 
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public abstract  class Monster extends Unit implements Interactable
{
	private boolean underAttack; 
	private float deltaSinceBeingAttacked;
	
	/** Current adversary */
	private Interactable adversary;
	
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
    
	public Interactable getAdversary() 
    {
		return adversary;
	}

	public void setAdversary(Interactable adversary) 
	{
		this.adversary = adversary;
	}

	public float getDeltaSinceBeingAttacked() 
    {
		return deltaSinceBeingAttacked;
	}

	public void setDeltaSinceBeingAttacked(float newDelta) 
	{
		this.deltaSinceBeingAttacked = newDelta;
	}
	
    public boolean isUnderAttack() 
    {
		return underAttack;
	}

	public void setUnderAttack(boolean underAttack) 
	{
		this.underAttack = underAttack;
	}
	
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
	
	@Override
	public boolean isActive() 
	{
		return this.getHP() >= 0;
	}
	
	public float getDistance(Interactable other)
	{
	    return (float)Math.sqrt((double)getPos().distanceSquared(other.getPos()));
	}
	
	@Override
	public boolean isWithinRange(Interactable other) 
	{
		return getDistance(other) <= Constant.COLLIDE_RANGE;
	}
	
	public boolean canFollow(Interactable other)
	{
		return getDistance(other) <= Constant.FOLLOW_RANGE;
	}
    
   
    
    



}