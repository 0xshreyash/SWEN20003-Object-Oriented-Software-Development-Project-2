
import java.util.*;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;



/**
 * 
 */
public abstract class MonsterAggressive extends Monster implements Interactable
{
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
    	this.setCoolDown(0);
    	isAttacking = false;
    	isIdle = true; 
    	isChasing = false;
    	
    	
    }
    
    public InteractorTag identifier()
    {
    	return InteractorTag.MonsterAggressive;
    }

 
    /**
     * @param otherObj 
     * @return
     */
    public void action(Interactable other) 
    {
    	this.setAdversary(other);
        if(this.getDistance(other) <= Constant.COLLIDE_RANGE)
        {
        	isAttacking = true; 
        	if(this.getCoolDown() <= 0 && other.identify() == InteractorTag.Player)
        	{
        		
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
    	if(this.getHP() <= 0)
    			this.setDead(true);
    	
    	if(!this.isDead())
    	{
    		this.setCoolDown(this.getCoolDown() - delta);
    		
    		if(this.getDistance(this.getAdversary()) <= Constant.FOLLOW_RANGE)
    		{
    			isChasing = true; 
    			isIdle = false; 
    			isAttacking = false;
    			this.setUnderAttack(false);
    			Vector2f moveIn = this.getAdversary().getPos().sub(this.getPos());
    			Vector2f moveTowards = moveIn.copy().scale(this.getSpeed()*delta);
    			if(!map.blocks(this.getxPos() + moveTowards.getX(), this.getyPos() + moveTowards.getY()))
    			{
    				this.setPos(this.getPos().add(moveTowards));
    				
    			}
    			else
    			{
    				this.setAdversary(null);
    				isIdle = true;
    				isChasing = false; 
    				isAttacking = false;
    			}
    		
    		}
    		
    			
    	}
    }

}