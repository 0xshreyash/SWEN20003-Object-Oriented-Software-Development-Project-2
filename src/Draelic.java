

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