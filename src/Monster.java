
import java.util.*;

import org.newdawn.slick.SlickException;

/**
 * 
 */
public abstract  class Monster extends Unit
{

	/**
     * 
     */
    private String name;
    private boolean isDead;

    public Monster(String MonsterImagePath, float starting_X, float starting_Y,
			int max_HP, float monster_speed, int max_Damage, int max_CoolDown, String MonsterName)
    throws SlickException
    {
    	super(MonsterImagePath, starting_X, starting_Y,
    		max_HP, monster_speed, max_Damage,max_CoolDown);
    	MonsterName = name;
    	isDead = false;
    }


	public boolean isInteractor(Interactable other) 
	{
		return other instanceof Player;
	}

	public Class<? extends Entity> getTag() 
	{
		// TODO Auto-generated method stub
		return this.getClass();
	}
	
	public boolean getIsDead()
	{
		return isDead;
		
	}
    
	public void setIsDead(boolean change)
	{
		isDead = change;
		return;
	}

}