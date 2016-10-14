

import org.newdawn.slick.SlickException;

/**
 * 
 */
public class Zombie extends MonsterAggressive {

    /**
     * Default constructor
     */
    public Zombie(float starting_X, float starting_Y) 
    throws SlickException
    {
    	super(Constant.ZOMBIE_PATH, starting_X, starting_Y,
    			Constant.ZombieHP, Constant.AG_MONSTER_SPEED, Constant.ZombieDamage, 
    			Constant.ZombieCooldown, Constant.ZOMBIE);
    }

}