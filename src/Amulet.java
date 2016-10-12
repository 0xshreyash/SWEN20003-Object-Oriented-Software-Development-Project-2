


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Amulet extends Item
{
	
	public static final int hpBonus; 
	
	
	public Amulet(float starting_X, float starting_Y, String item_Image, String item_Name, int HP_BONUS) 
	throws SlickException
	{
		super(starting_X, starting_Y, item_Image, item_Name);
		hpBonus = HP_BONUS;	
	}
	
	public 

}