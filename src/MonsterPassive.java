
import java.util.*; 

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 * 
 */
public abstract class MonsterPassive extends Monster implements Interactable
{
	
	private float timeAfterLastDirectionChange; 
	
	private Random rndm;
	
	private Vector2f moveIn;
	
	private boolean isPatrolling;
	
	
	private boolean runAway;

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
    	runAway = false;
    	timeAfterLastDirectionChange = 0;
    	
    }
	
	public InteractorTag identifier()
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
        if(this.isUnderAttack())
        {
        	isPatrolling = false;
        	// change isPatrolling when underAttack is made true. 
        	this.moveAway(map, delta);
        }
        else if(this.isPatrolling)
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
        }
        else if(runAway)
        {
        	moveAway(map, delta);
        }
        			
        return;   
    }
    
    public void moveAway(Map map, int delta)
    {
    	runAway = true; 
    	this.setUnderAttack(false);
    	if(this.getDeltaSinceBeingAttacked() >= Constant.TIME_TO_SAFETY)
    	{
    		runAway = false;
    		isPatrolling = true;
    		this.setDeltaSinceBeingAttacked(0);
    	}
    	else 
    	{
    		Vector2f direction = getPos().sub(this.getAdversary().
    				getPos()).getNormal();
    		this.setDeltaSinceBeingAttacked(delta);
    		Vector2f moveTowards = direction.copy().scale(this.getSpeed()*delta);
    		if(!map.blocks(this.getxPos() + moveTowards.getX(), this.getyPos() + moveTowards.getY()))
    		{
    			this.setPos((this.getPos().add(moveTowards)));
    		}
    		else
    		{
    			timeAfterLastDirectionChange = Constant.TIME_TO_CHANGE_DIRECTION;
    		}
    		this.setUnderAttack(false);
    		runAway = true;		
    	}
    }
  
   
    public void action(Interactable other) 
    {
    	return;
    }
    

}