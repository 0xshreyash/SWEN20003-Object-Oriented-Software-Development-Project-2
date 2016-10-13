
import java.util.*; 
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public abstract  class Monster extends Unit
{
	private boolean underAttack; 
	private float deltaSinceBeingAttacked;
	private Interactable adversary;
	
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

	public void setDeltaSinceBeingAttacked(float delta) 
	{
		this.deltaSinceBeingAttacked += delta;
	}

	public Monster(String MonsterImagePath, float starting_X, float starting_Y,
			int max_HP, float monster_speed, int max_Damage, int max_CoolDown, String MonsterName)
    throws SlickException
    {
    	super(MonsterImagePath, starting_X, starting_Y,
    		max_HP, monster_speed, max_Damage,max_CoolDown, MonsterName);
    	underAttack = false; 
    	deltaSinceBeingAttacked = 0f;
    	adversary = null;
    }
    
    public boolean isUnderAttack() 
    {
		return underAttack;
	}

	public void setUnderAttack(boolean underAttack) 
	{
		this.underAttack = underAttack;
	}

	public void render(Graphics g)
    {
    	if(!isDead())
    	{
    		renderHealthBar(g);
    		if(this.isFacingRight())
    		{
    			this.getImage().drawCentered(this.getxPos(), this.getyPos());
    			
    		}
    		else
    		{
    			this.getImageInverted().drawCentered(this.getxPos(), this.getyPos());
    		}
    	}
    }
	
	public float getDistance(Interactable other)
	{
	    return (float)Math.sqrt((double)getPos().distanceSquared(other.getPos()));
	}
    
   
    
    



}