/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 */

import org.newdawn.slick.SlickException;

/**
 * Skeleton that inerits from MonsterAggressive
 */
public class Skeleton extends MonsterAggressive 
{

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