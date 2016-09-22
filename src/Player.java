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

	
	/** Speed of the player. */
	private static final double SPEED = 0.25;
 
    /** Creates the player object.  
     * @param playerImagePath - the path to the file containing the image
     * of the player.
     */
	public Player(String playerImagePath) 
	throws SlickException
	{
		super(playerImagePath, RPG.starting_X, RPG.starting_Y);	
	}
	
	/** Will kill enemies. */
	public void Kill()
	throws SlickException
	{
		
	
	}
	
	/** Updates the position of the player in order to render it.
	 * @param map - The Map object we use to see if the tile is
	 * blocking or not. 
	 * @param dir_x - the direction of movement in the x-direction.
	 * @param dir_y - the direction of movement in the y-direction.
	 * @param delta - the time elapsed since the last update.
	 * @return - void.
	 */
	public void update(Map map, double dir_x, double dir_y, int delta)
	{
		/* Prospective x and y-coordinates computed */
		double new_xPos  = this.getxPos() + dir_x*SPEED * delta; 
		double new_yPos =  this.getyPos() + dir_y*SPEED * delta; 
		
		/* Check for blocking of the player by certain tiles and 
		 * halt movement if a certain tile blocks. 
		 */
		/* Update only the yPos if the xPos caused the blocking. */ 
		if(map.blocks(new_xPos, new_yPos) && !map.blocks(this.xPos, new_yPos))
		{
			
			/* Making sure the new y-position is on the game board. */
			if(!((int)Math.floor(new_yPos) <= RPG.min_Y
			 || (int)Math.ceil(new_yPos) >= RPG.gameheight))
			{
				this.setxPos(new_yPos); 
			}	 
		}
		/* Update only the xPos if the yPos is causing the blocking. */
		else if(map.blocks(new_xPos, new_yPos) && !map.blocks(new_xPos, getyPos()))
		{
			
			/* Making sure the new x-position is on the game board. */
			if(!((int)Math.floor(new_xPos) <= RPG.min_X
			 || (int)Math.ceil(new_xPos) >= RPG.gamewidth))
			{
				this.setxPos(new_xPos);; 
			}
		}
		/* Update both if none of the xPos and yPos cause blocking. */
		else if(!map.blocks(new_xPos, new_yPos))
		{
			/* Making sure the new x-position is on the game board. */
			if(!((int)Math.floor(new_xPos) <= RPG.min_X
			 || (int)Math.ceil(new_xPos) >= RPG.gamewidth))
			{
				this.setxPos(new_xPos);; 
			}
			/* Making sure the new y-position is on the game board. */
			if(!((int)Math.floor(new_yPos) <= RPG.min_Y
			 || (int)Math.ceil(new_yPos) >= RPG.gameheight))
			{
				this.setxPos(new_yPos);
			}	
		}	
		/* Check which side the player is facing. */
		if(dir_x > 0)
		{
			this.facing_right = true; 
		}
		else if(dir_x < 0)
		{
			this.facing_right = false; 
		}		
	}

}
