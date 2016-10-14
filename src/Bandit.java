

import org.newdawn.slick.SlickException;

/**
 * 
 */
public class Bandit extends MonsterAggressive {

    /**
     * Default constructor
     */
    public Bandit(float starting_X, float starting_Y) 
    throws SlickException
    {
    		    
    	super(Constant.BANDIT_PATH, starting_X, starting_Y,
		Constant.BanditHP, Constant.AG_MONSTER_SPEED, Constant.BanditDamage, 
		Constant.BanditCooldown, Constant.BANDIT);
    			    
    }

}