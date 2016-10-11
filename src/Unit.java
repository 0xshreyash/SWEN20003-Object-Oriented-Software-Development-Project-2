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

public class Unit extends Entity
{
	/** Max HP of the Unit */ 
	private final int maxHP;
	/** HP of the Unit */
	private int HP; 
	
	/** Image of the unit. */
	private Image unit_image = null; 
	/** Inverted image of the unit. */
	private Image unit_image_inverted = null;
	
	boolean facing_right = true;
	
	/** Speed of the unit */
	private final float speed;
	
	/** Max damage caused by the Unit */ 
	private final int maxDamage;
	
	/** Max coolDown time of the Unit */
	private final int maxCoolDown;
	/** coolDown time of the Unit */
	private int coolDown; 
	
	private boolean isDead = false;

    /** Creates the player object.  
     * @param playerImagePath - the path to the file containing the image
     * of the player.
     */
	public Unit(String playerImagePath) 
	throws SlickException
	{
		super(playerImagePath, starting_X, starting_Y);	
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
		if(map.blocks(new_xPos, new_yPos) && !map.blocks(this.getxPos(), new_yPos))
		{
			
			/* Making sure the new y-position is on the game board. */
			if(!((int)Math.floor(new_yPos) <= Constant.min_Y
			 || (int)Math.ceil(new_yPos) >= Constant.gameheight))
			{
				this.setxPos(new_yPos); 
			}	 
		}
		/* Update only the xPos if the yPos is causing the blocking. */
		else if(map.blocks(new_xPos, new_yPos) && !map.blocks(new_xPos, getyPos()))
		{
			
			/* Making sure the new x-position is on the game board. */
			if(!((int)Math.floor(new_xPos) <= Constant.min_X
			 || (int)Math.ceil(new_xPos) >= Constant.gamewidth))
			{
				this.setxPos(new_xPos);; 
			}
		}
		/* Update both if none of the xPos and yPos cause blocking. */
		else if(!map.blocks(new_xPos, new_yPos))
		{
			/* Making sure the new x-position is on the game board. */
			if(!((int)Math.floor(new_xPos) <= Constant.min_X
			 || (int)Math.ceil(new_xPos) >= Constant.gamewidth))
			{
				this.setxPos(new_xPos);; 
			}
			/* Making sure the new y-position is on the game board. */
			if(!((int)Math.floor(new_yPos) <= Constant.min_Y
			 || (int)Math.ceil(new_yPos) >= Constant.gameheight))
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
	
	public void render(Graphics g, double cam_minX, double cam_minY)
	{
		/* Using translate to make sure the player is printed on 
		 * the screen. */
		g.translate(-(float)cam_minX, -(float)cam_minY);
		
		/* Draw the player on the screen based on the side (s)he is 
		 * facing. */
		if(this.facing_right)
		{
			Constant.PLAYER.drawCentered((float)xPos, (float)yPos);
		}
		else
		{
			unit_image_inverted.drawCentered((float)xPos, (float)yPos);
		}		
	}

}
