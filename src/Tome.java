


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Tome extends Item
{
	
	public static int attackSpeedBoost; 
	
	
	public Tome(float starting_X, float starting_Y, String item_Image, String item_Name, int decrease_coolDown) 
	throws SlickException
	{
		super(starting_X, starting_Y, item_Image, item_Name);
		attackSpeedBoost = decrease_coolDown;	
	}
	
	public void action(Interactable other)
	{
		if(this.getCollected() && this.isInteractor(other))
		{
			other.action(this);
		}
		return;
	}
	


}
