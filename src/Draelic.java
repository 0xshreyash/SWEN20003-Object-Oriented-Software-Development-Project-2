/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 */

import org.newdawn.slick.SlickException;

/**
 * 
 */
public class Draelic extends MonsterAggressive {

    /**
     * Default constructor
     */
	public Draelic(float starting_X, float starting_Y) 
    throws SlickException
    {
    	super(Constant.NECROMANCER_PATH, starting_X, starting_Y,
    			Constant.DraelicHP, Constant.AG_MONSTER_SPEED, Constant.DraelicDamage, 
    			Constant.DraelicCooldown, Constant.NECROMANCER);
    }

}