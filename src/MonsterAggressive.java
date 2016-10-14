


import org.newdawn.slick.SlickException; 



/**
 * 
 */
public class MonsterAggressive extends Monster implements Interactable
{
	/* Help keep track of the state */
	private boolean isAttacking;
	private boolean isIdle;
	private boolean isChasing;
	
	
    /**
     * Default constructor
     */
    public MonsterAggressive(String MonsterImagePath, float starting_X, float starting_Y,
			int max_HP, float monster_speed, int max_Damage, int max_CoolDown, String MonsterName)
    throws SlickException
    {
    	super(MonsterImagePath, starting_X, starting_Y,
    			max_HP, monster_speed, max_Damage, max_CoolDown, MonsterName);
    	// Can attack from the get go
    	isAttacking = false;
    	isIdle = true; 
    	isChasing = false;   
    	
    	
    }
    
    public InteractorTag identify()
    {
    	return InteractorTag.MonsterAggressive;
    }

 
    /**
     * @param otherObj 
     * @return
     */
    public void action(Interactable other) 
    {
    	if(other.identify() == InteractorTag.Player)
    	{
    		this.setAdversary(other);
	        if(this.getDistance(other) <= Constant.COLLIDE_RANGE)
	        {
	        	
	        	if(this.getCoolDown() <= 0)
	        	{
	        		isAttacking = true; 
	        		((Player)other).setHP(((Player)other).getHP() - (int)(Math.random()*this.getMaxDamage()));
	        		this.setCoolDown(this.getMaxCoolDown());
	        	}
	        	
	        }
	        else if(this.getDistance(other) <= Constant.FOLLOW_RANGE)
	        {
	        	this.isChasing = true;
	        }
    	}
        
        
    }

    /**
     * @param map 
     * @param interactables 
     * @param delta 
     * @return
     */
    public void update(Map map, int delta)
    {
    	this.setDead();
    	if(this.isDead())
    		return;
    	
    	if(!this.isDead())
    	{
    		this.setCoolDown(this.getCoolDown() - delta);
    		
    		if(this.getAdversary()!= null && this.getDistance(this.getAdversary()) <= Constant.FOLLOW_RANGE &&
    				this.getDistance(this.getAdversary()) > Constant.COLLIDE_RANGE)
    		{
    			if(this.getAdversary().identify() == InteractorTag.Player)
    			{
	    			isChasing = true; 
	    			isIdle = false; 
	    			isAttacking = false;
	    			this.setUnderAttack(false);
	    			float distTotal = 0, dX, dY;
	    	    	distTotal = (float) Math.sqrt((float)(Math.pow(((Player)this.getAdversary()).getxPos() - this.getxPos(), 2) 
	    	    			+ Math.pow(((Player)this.getAdversary()).getyPos() - this.getyPos(), 2)));
	    	    	dX = ((((Player)this.getAdversary()).getxPos() - this.getxPos())/distTotal) * delta * this.getSpeed();
	    	    	dY = ((((Player)this.getAdversary()).getyPos() - this.getyPos())/distTotal) * delta * this.getSpeed();
	    	    	//Vector2f moveIn = this.getAdversary().getPos().sub(this.getPos()).getNormal();
	    	    	//Vector2f moveTowards = moveIn.copy().scale(this.getSpeed()*delta);
	    			if(!map.blocks(this.getxPos() + dX, 
	    					this.getyPos() + dY))
	    			{
	    				this.setxPos(this.getxPos() + dX);	
	    				this.setyPos(this.getyPos() + dY);
	    			}
	    			else
	    			{
	    				isIdle = true;
	    				isChasing = false; 
	    				isAttacking = false;
	    			} 
    			}
    		} 
    		
    		else
    		{
    			isIdle = true;
    			isChasing = false;
    			isAttacking = false;
    		}
    	}
    	return;
    }

	

	@Override
	public boolean isSame(Object other) 
	{
		if(other == null || other.getClass() != this.getClass())
		{
			return false;
		}
		
		return other == this;
	}

	@Override
	public void update(Map map, float dir_x, float dir_y, int delta, int attack, int talk) {
		// TODO Auto-generated method stub
		
	}

	public boolean isAttacking() {
		
		return isAttacking;
	}

	public void setAttacking(boolean isAttacking) 
	{
		this.isAttacking = isAttacking;
	}

	public boolean isIdle()
	{
		return isIdle;
	}

	public void setIdle(boolean isIdle) 
	{
		this.isIdle = isIdle;
	}

	public boolean isChasing() 
	{
		return isChasing;
	}

	public void setChasing(boolean isChasing) 
	{
		this.isChasing = isChasing;
	}
	
	@Override
	public boolean isWithinRange(Interactable other) 
	{
		return getDistance(other) <= Constant.COLLIDE_RANGE ||
				getDistance(other) <= Constant.FOLLOW_RANGE;
	}
	


}