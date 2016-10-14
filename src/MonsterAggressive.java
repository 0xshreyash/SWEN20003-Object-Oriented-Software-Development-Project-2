/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 */


import org.newdawn.slick.SlickException; 

/**
 * MonsterAggressive inherits from Monster and it can attack the Player
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
	    	// These are just to keep the reader intact with what's the intention of 
	    	// each part of the program, 
	    	isAttacking = false;
	    	isIdle = true; 
	    	isChasing = false;   
   
    }
    
    /**
     * Returns the identity of the player
     * @return InteractorTag - identity of the MonsterAgressive
     */
    public InteractorTag identify()
    {
    		return InteractorTag.MonsterAggressive;
    }

 
    /**
     * Implement the action that the object takes in 
     * the proximity of different Interactables
     * @param other 
     * @return void
     */
    public void action(Interactable other) 
    {
	    	if(other.identify() == InteractorTag.Player)
	    	{
	    		/* if the other is a PLayer then attack it and treat it is
	    		 * an adversary
	    		 */
    			this.setAdversary(other);
	        if(this.getDistance(other) <= Constant.COLLIDE_RANGE)
	        {
	        	
		        	if(this.getCoolDown() <= 0)
		        	{
		        		isAttacking = true; 
		        		// Change player's HP
		        		((Player)other).setHP(((Player)other).getHP() - 
		        				(int)(Math.random()*this.getMaxDamage()));
		        		this.setCoolDown(this.getMaxCoolDown());
		        	}
	        	
	        }
	        // Check if other is withinRange to chase
	        else if(this.getDistance(other) <= Constant.FOLLOW_RANGE)
	        {
	        		this.isChasing = true;
	        }
	    	}
        
        
    }

    /**
     * Updates the aggressive monsters with appropriate behaviour
     * @param map - to check for blocking 
     * @param delta - time since last update (in mSec)
     * @return
     */
    public void update(Map map, int delta)
    {
	    	this.setDead();
	    	if(this.isDead())
	    		return;
	    	
	    	if(!this.isDead())
	    	{
	    		// Countdown to next attack
	    		this.setCoolDown(this.getCoolDown() - delta);
	    		
	    		if(this.getAdversary()!= null && 
	    				this.getDistance(this.getAdversary()) <= Constant.FOLLOW_RANGE &&
	    				this.getDistance(this.getAdversary()) > Constant.COLLIDE_RANGE)
	    		{
	    			if(this.getAdversary().identify() == InteractorTag.Player)
	    			{
		    			isChasing = true; 
		    			isIdle = false; 
		    			isAttacking = false;
		    			this.setUnderAttack(false);
		    			float distTotal = 0, dX, dY;
		    			/* Using algorithm to find where to go */
		    	    		distTotal = (float) Math.sqrt((float)(Math.pow((
		    	    				(Player)this.getAdversary()).getxPos() - this.getxPos(), 2) 
		    	    			+ Math.pow(((Player)this.getAdversary()).getyPos() - 
		    	    					this.getyPos(), 2)));
			    	    	dX = ((((Player)this.getAdversary()).getxPos() - 
			    	    			this.getxPos())/distTotal) * delta * this.getSpeed();
			    	    	dY = ((((Player)this.getAdversary()).getyPos() - 
			    	    			this.getyPos())/distTotal) * delta * this.getSpeed();
			    	    /* Check for blocking */
		    			if(!map.blocks(this.getxPos() + dX, 
		    					this.getyPos() + dY))
		    			{
		    				this.setxPos(this.getxPos() + dX);	
		    				this.setyPos(this.getyPos() + dY);
		    			}
		    			else
		    			{
		    				/* Update states */
		    				isIdle = true;
		    				isChasing = false; 
		    				isAttacking = false;
		    			} 
	    			}
	    		} 
	    		
	    		else
	    		{
	    			/* Update states */
	    			isIdle = true;
	    			isChasing = false;
	    			isAttacking = false;
	    		}
	    	}
	    	return;
    }

	/**
	 * Checks if the other is same as this object
	 * @param other of type Object
	 */
	@Override
	public boolean isSame(Object other) 
	{
		if(other == null || other.getClass() != this.getClass())
		{
			return false;
		}
		
		return other == this;
	}
	
	/**
	 * Update function in order to be able to implement the interface properly
	 */
	@Override
	public void update(Map map, float dir_x, float dir_y, int delta, int attack, int talk) {
		// TODO Auto-generated method stub
		
	}

	/** 
	 * Checks if the MonsterAggressive is attacking
	 * @return true if the MonsterAggressive is attacking
	 */
	public boolean isAttacking() {
		
		return isAttacking;
	}
	
	/**
	 * sets the Attacking status of MonsterAggressive
	 * @param isAttacking - the value to be assigned
	 */
	public void setAttacking(boolean isAttacking) 
	{
		this.isAttacking = isAttacking;
	}

	/**
	 * Checks if the MonsterAggressive is idle or not
	 * @return true if the MonsterAggressive is idle
	 */
	public boolean isIdle()
	{
		return isIdle;
	}
	
	/**
	 * Changes the idle state of MonsterAggressive
	 * @param isIdle - value to be assigned
	 */
	public void setIdle(boolean isIdle) 
	{
		this.isIdle = isIdle;
	}

	/**
	 * Checks if the MonsterAggressive isChasing()
	 * @return true if the MonsterAgressive is chasing
	 */
	public boolean isChasing() 
	{
		return isChasing;
	}

	/**
	 * sets the chasing status of MonsterAggressive
	 * @param isChasing
	 */
	public void setChasing(boolean isChasing) 
	{
		this.isChasing = isChasing;
	}
	
	/**
	 * Checks if other is in range to be 'acted' 
	 * upon
	 * @param other of type Interactable
	 * @return true if other can be 'acted' upon
	 */
	@Override
	public boolean isWithinRange(Interactable other) 
	{
		return getDistance(other) <= Constant.COLLIDE_RANGE ||
				getDistance(other) <= Constant.FOLLOW_RANGE;
	}
	


}