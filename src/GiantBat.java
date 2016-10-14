import org.newdawn.slick.SlickException;

public class GiantBat extends MonsterPassive
{

	public GiantBat(float starting_X, float starting_Y) 
	throws SlickException
	{
		
		super(Constant.DREADBAT_PATH, starting_X, starting_Y,
				Constant.BatHP, Constant.PA_MONSTER_SPEED, Constant.BatDamage, 
				Constant.BatCooldown, Constant.DREADBAT);
	}

}
