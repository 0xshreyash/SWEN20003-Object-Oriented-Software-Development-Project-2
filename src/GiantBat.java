/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 */
import org.newdawn.slick.SlickException;

public class GiantBat extends MonsterPassive
{

	/** The default constructor for this class
	 */
	public GiantBat(float starting_X, float starting_Y) 
	throws SlickException
	{
		
		super(Constant.DREADBAT_PATH, starting_X, starting_Y,
				Constant.BatHP, Constant.PA_MONSTER_SPEED, Constant.BatDamage, 
				Constant.BatCooldown, Constant.DREADBAT);
	}

}
