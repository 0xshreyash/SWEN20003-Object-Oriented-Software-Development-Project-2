/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 * 
 * This file contains the Player class which controls the player
 * in the program.
 */

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player extends Unit implements Interactable
{
	private boolean talk;
    /** Creates the player object.  
     * @param playerImagePath - the path to the file containing the image
     * of the player.
     */
	public Player() 
	throws SlickException
	{
		//String UnitImagePath, float starting_X, float starting_Y,
		//int max_HP, float unit_speed, int max_Damage, int max_CoolDown
		super(Constant.PLAYER_PATH, Constant.player_starting_X, Constant.player_starting_Y, 
				Constant.PlayerHP, Constant.PLAYER_SPEED, Constant.PlayerDamage, Constant.PlayerCooldown, Constant.PLAYER);
		talk = false;
		
	}
	
	/** Updates the position of the player in order to render it.
	 * @param map - The Map object we use to see if the tile is
	 * blocking or not. 
	 * @param dir_x - the direction of movement in the x-direction.
	 * @param dir_y - the direction of movement in the y-direction.
	 * @param delta - the time elapsed since the last update.
	 * @return - void.
	 */
	public void update(Map map, float dir_x, float dir_y, int delta, int attack, int talk)
	{
		
		
	}
	
	public boolean isTalking()
	{
		return talk;
	}
	

	public void action(Interactable other) 
	{
		if(this.isInteractor(other))
		{
			
		}
		
	}
	
	 public ArrayList<Item> getItems() {
	        return inv.getItems();
	    }

	    public boolean hasItem(String itemName) {
	        for (Item item : getItems())
	            if (item.equals(itemName))
	                return true;
	        return false;
	    }

	    public void takeItem(String itemName) throws SlickException {
	        bag.takeItem(itemName);
	    }

	    public void takeItem(Item... item) {
	        bag.addItem(item);
	    }
}
