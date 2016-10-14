
import java.util.*; 

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 * 
 */
public class MonsterPassive extends Monster implements Interactable
{
	
	private float timeAfterLastDirectionChange; 
	
	private Random rndm;
	
	/** Direction to move in */ 
	private Vector2f moveIn;
	
	private boolean isPatrolling;

	private boolean isRunningAway;

    /**
     * Default constructor
     */
	public MonsterPassive(String MonsterImagePath, float starting_X, float starting_Y,
			int max_HP, float monster_speed, int max_Damage, int max_CoolDown, String MonsterName)
	throws SlickException
    {
    	super(MonsterImagePath, starting_X, starting_Y,
    			max_HP, monster_speed, max_Damage, max_CoolDown, MonsterName);
    	rndm = new Random();
    	moveIn = getRandomDirection();
    	isPatrolling = true;
    	isRunningAway = false;
    	timeAfterLastDirectionChange = 0;
    	
    }
	
	public InteractorTag identify()
    {
    	return InteractorTag.MonsterPassive;
    }

    
    private Vector2f getRandomDirection() 
    {
        return new Vector2f(rndm.nextInt(), rndm.nextInt()).getNormal();
    }
    
    /**
     * @param map 
     * @param player 
     * @param delta 
     * @return
     */
    public void update(Map map, int delta) 
    {
    	this.setDead();
    	if(this.isDead())
    		return;
        if(this.isUnderAttack())
        {
        	isPatrolling = false;
        	isRunningAway = true;
        	this.moveAway(map, delta);
        }
        if(this.isPatrolling)
        {
        	timeAfterLastDirectionChange += delta; 
        	if(timeAfterLastDirectionChange >= Constant.TIME_TO_CHANGE_DIRECTION)
        	{
        		moveIn = getRandomDirection();
        		timeAfterLastDirectionChange = 0;
        		
        	}
        	Vector2f moveTowards = moveIn.copy().scale(this.getSpeed()*delta);
        	if(!map.blocks(this.getxPos() + moveTowards.getX(), this.getyPos() + moveTowards.getY()))
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
        	timeAfterLastDirectionChange += delta; 
        	if(timeAfterLastDirectionChange >= Constant.TIME_TO_CHANGE_DIRECTION)
        	{
        		
        		
        	}
        	Vector2f moveTowards = moveIn.copy().scale(this.getSpeed()*delta);
        	if(!map.blocks(this.getxPos() + moveTowards.getX(), this.getyPos() + moveTowards.getY()))
        	{
        		this.setPos(this.getPos().add(moveTowards));
        	}
        	moveAway(map, delta);
        	this.setDeltaSinceBeingAttacked(this.getDeltaSinceBeingAttacked() + delta);
        }
        			
        return;   
    }
    
    public void moveAway(Map map, int delta)
    {
    	isRunningAway = true; 
    	this.setUnderAttack(false);
    	if(this.getDeltaSinceBeingAttacked() >= Constant.TIME_TO_SAFETY)
    	{
    		isRunningAway = false;
    		isPatrolling = true;
    		moveIn = getRandomDirection();
    		timeAfterLastDirectionChange = 0;
    	}
    	else 
    	{
    		float distTotal = 0, dX, dY;
	    	distTotal = (float) Math.sqrt((float)(Math.pow(((Player)this.getAdversary()).getxPos() - this.getxPos(), 2) 
	    			+ Math.pow(((Player)this.getAdversary()).getyPos() - this.getyPos(), 2)));
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
  
   
    public void action(Interactable other) 
    {
    	if(other.identify() == InteractorTag.Player)
    		this.setAdversary(other);
    	return;
    }

	@Override
	public boolean isWithinRange(Interactable other) 
	{
		// TODO Auto-generated method stub
		return getDistance(other) <= Constant.COLLIDE_RANGE;
	}

	

	@Override
	public void update(Map map, float dir_x, float dir_y, int delta, int attack, int talk) {
		// TODO Auto-generated method stub
		
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

	
    

}