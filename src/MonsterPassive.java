/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 */

import java.util.*; 

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 * 
 */
public class MonsterPassive extends Monster implements Interactable
{
	/** stores time since the last change of direction */
	private float timeAfterLastDirectionChange; 
	
	/** Random object */
	private Random rndm;
	
	/** Direction to move in */ 
	private Vector2f moveIn;
	
	/** Stores the patrolling state of the MonsterPassive */
	private boolean isPatrolling;

	/** Stores whether the MonsterPassive is running away */
	private boolean isRunningAway;

    /**
     * Default constructor
     */
	public MonsterPassive(String MonsterImagePath, float starting_X, float starting_Y,
			int max_HP, float monster_speed, int max_Damage, int max_CoolDown, 
			String MonsterName) throws SlickException
    {
    	super(MonsterImagePath, starting_X, starting_Y,
    			max_HP, monster_speed, max_Damage, max_CoolDown, MonsterName);
    	rndm = new Random();
    	moveIn = getRandomDirection();
    	isPatrolling = true;
    	isRunningAway = false;
    	timeAfterLastDirectionChange = 0;
    	
    }
	
	/**
	 * Get the tag of the Interactable 
	 * @return - InteractorTag with identity of the 
	 */
	public InteractorTag identify()
    {
    	return InteractorTag.MonsterPassive;
    }

    /**
     * gets a random direction in Vecotr2f format
     * @return Vector2f random direction in Vector2f format
     */
    private Vector2f getRandomDirection() 
    {
        return new Vector2f(rndm.nextInt(), rndm.nextInt()).getNormal();
    }
    
    /** Updates the monster's position in the world
     * @param map - the map to check for blocking
     * @param delta - time since lastUpdate
     * @return void
     */
    public void update(Map map, int delta) 
    {
    	this.setDead();
    	if(this.isDead())
    		return;
        if(this.isUnderAttack())
        {
        	/* State of the MonsterPassive */
        	isPatrolling = false;
        	isRunningAway = true;
        	this.moveAway(map, delta);
        }
        if(this.isPatrolling)
        {
        	timeAfterLastDirectionChange += delta; 
        	/* Count down to the time to change direction */
        	if(timeAfterLastDirectionChange >= Constant.TIME_TO_CHANGE_DIRECTION)
        	{
        		/* Change direction if the countdown is up */
        		moveIn = getRandomDirection();
        		timeAfterLastDirectionChange = 0;
        		
        	}
        	
        	/* Move in a random direction until it's time to change direction or 
        	 * we experience blocking
        	 */
        	Vector2f moveTowards = moveIn.copy().scale(this.getSpeed()*delta);
        	if(!map.blocks(this.getxPos() + moveTowards.getX(), 
        			this.getyPos() + moveTowards.getY()))
        	{
        		this.setPos(this.getPos().add(moveTowards));
        	}
        	else
        	{
        		timeAfterLastDirectionChange = Constant.TIME_TO_CHANGE_DIRECTION;
        	}
        	
        	this.setDeltaSinceBeingAttacked(this.getDeltaSinceBeingAttacked() + delta);
        }
        else if(isRunningAway)
        {
        	/* Implement what happens if MonsterPassive is running away from attacker */
        	timeAfterLastDirectionChange += delta; 
        	if(timeAfterLastDirectionChange >= Constant.TIME_TO_CHANGE_DIRECTION)
        	{
        		
        		
        	}
        	Vector2f moveTowards = moveIn.copy().scale(this.getSpeed()*delta);
        	if(!map.blocks(this.getxPos() + moveTowards.getX(), 
        			this.getyPos() + moveTowards.getY()))
        	{
        		this.setPos(this.getPos().add(moveTowards));
        	}
        	moveAway(map, delta);
        	this.setDeltaSinceBeingAttacked(this.getDeltaSinceBeingAttacked() + delta);
        }
        			
        return;   
    }
    
    /** Applying the Algorithm1 to run away
     * @param map the game map
     * @param delta value
     */
    public void moveAway(Map map, int delta)
    {
    	isRunningAway = true; 
    	this.setUnderAttack(false);
    	if(this.getDeltaSinceBeingAttacked() >= Constant.TIME_TO_SAFETY)
    	{
    		/* Current state of the MonsterPassive */
    		isRunningAway = false;
    		isPatrolling = true;
    		moveIn = getRandomDirection();
    		timeAfterLastDirectionChange = 0;
    	}
    	else 
    	{
    		float distTotal = 0, dX, dY;
    		int sq = 2;
	    	distTotal = (float) Math.sqrt((float)(Math.pow(((Player)this.getAdversary()).getxPos() - this.getxPos(), sq) 
	    			+ Math.pow(((Player)this.getAdversary()).getyPos() - this.getyPos(), sq)));
	    	dX = -((((Player)this.getAdversary()).getxPos() - this.getxPos())/distTotal) * delta * this.getSpeed();
	    	dY = -((((Player)this.getAdversary()).getyPos() - this.getyPos())/distTotal) * delta * this.getSpeed();
	    	if(Math.abs(dX) <= Constant.VERY_SMALL_DISTANCE)
	    	{
	    		Random rand = new Random();
	    		this.setxPos(this.getxPos() + rand.nextInt((Constant.posDirection - Constant.negDirection) + 1) + Constant.negDirection);
	    		
	    	}
	    	if(Math.abs(dY) <= Constant.VERY_SMALL_DISTANCE)
	    	{
	    		Random rand = new Random();
	    		this.setyPos(this.getyPos() + rand.nextInt((Constant.posDirection - Constant.negDirection) + 1) + Constant.negDirection);
	    		
	    	}
	    	else if(!map.blocks(this.getxPos() + dX, this.getyPos() +  dY))
    		{
    			this.setxPos(this.getxPos() + dX);	
				this.setyPos(this.getyPos() + dY);
    		}
    		else
    		{
    			timeAfterLastDirectionChange = Constant.TIME_TO_CHANGE_DIRECTION;
    		}
    		this.setUnderAttack(false);
    		isRunningAway = true;		
    	}
    	
    	return;
    }
  
   /** Deciding the action of the monster
    */
    public void action(Interactable other) 
    {
    	if(other.identify() == InteractorTag.Player)
    		this.setAdversary(other);
    	return;
    }

	@Override
	/** Checks if the monster is in range
	 */
	public boolean isWithinRange(Interactable other) 
	{
		// TODO Auto-generated method stub
		return getDistance(other) <= Constant.COLLIDE_RANGE;
	}

	

	@Override
	/** Updates the new state of the world, and so program doesn't carsh
	 */
	public void update(Map map, float dir_x, float dir_y, int delta, int attack, int talk) 
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	/** Checking if a monster is the same as the other
	 */
	public boolean isSame(Object other) 
	{
		if(other == null || other.getClass() != this.getClass())
		{
			return false;
		}
		
		return other == this;
	}

	
    

}