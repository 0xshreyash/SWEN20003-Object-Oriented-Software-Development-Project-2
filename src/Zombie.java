/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 */

import org.newdawn.slick.SlickException;

/**
 * Zombie class that inherits from MonsterAggressive
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