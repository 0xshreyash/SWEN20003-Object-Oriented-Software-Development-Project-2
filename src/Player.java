/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 * 
 * This file contains the Player class which controls the player
 * in the program.
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player extends Unit
{

    /** Creates the player object.  
     * @param playerImagePath - the path to the file containing the image
     * of the player.
     */
	public Player(String playerImagePath, float starting_X, float starting_Y,
			int max_HP, float player_speed, int max_Damage, int max_CoolDown) 
	throws SlickException
	{
		//String UnitImagePath, float starting_X, float starting_Y,
		//int max_HP, float unit_speed, int max_Damage, int max_CoolDown
		super(playerImagePath, starting_X, starting_Y, max_HP, player_speed, max_Damage, max_CoolDown);	
		
	}
	
	/** Updates the position of the player in order to render it.
	 * @param map - The Map object we use to see if the tile is
	 * blocking or not. 
	 * @param dir_x - the direction of movement in the x-direction.
	 * @param dir_y - the direction of movement in the y-direction.
	 * @param delta - the time elapsed since the last update.
	 * @return - void.
	 */
	public void update(Map map, float dir_x, float dir_y, int delta, int )
	{
		super.update(map, dir_x, dir_y, delta);	
		
	}

	public void render(Graphics g, float cam_minX, float cam_minY)
	{
		
		
	}

	@Override
	public boolean withinRange(Interactable other) {
		return super.withinRange(Interactable other);
	}

	@Override
	public void action(Interactable other) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isInteractor(Interactable other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Enum<?>[] getTag() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Map map, int dir_x, int dir_y, int delta) {
		// TODO Auto-generated method stub
		
	}
}
