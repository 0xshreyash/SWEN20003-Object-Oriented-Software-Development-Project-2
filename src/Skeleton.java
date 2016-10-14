

import org.newdawn.slick.SlickException;

/**
 * 
 */
public class Skeleton extends MonsterAggressive {

    /**
     * Default constructor
     */
	 public Skeleton(float starting_X, float starting_Y) 
     throws SlickException
     {
    	super(Constant.SKELETON_PATH, starting_X, starting_Y,
    			Constant.SkeletonHP, Constant.AG_MONSTER_SPEED, Constant.SkeletonDamage, 
    			Constant.SkeletonCooldown, Constant.SKELETON);
     }

}