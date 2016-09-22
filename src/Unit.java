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

public class Unit
{
	/**************** Attributes *********************/
	
	/** Image of the player. */
	private Image unit_image = null; 
	
	/** Inverted image of the player. */
	private Image unit_image_inverted = null;
	
	/** Starting coordinates of the player. */
	/** Starting x-coordinate of the player. */

	

	
	/** Current coordinates of the player.*/
	/** x-coordinate of the player. */
	private double xPos = 0; 
	/** y-coordinate of the player. */
	private double yPos = 0; 
	
	/** Direction the player is facing. */
	private boolean facing_right = true; 
	

	
	/***************** Methods ***********************/
	
	/** Gets the x-coordinate of the player.
	 * @param No parameters.
	 * @return xPos - x-coordinate of the player.
	 */
    public double getxPos() 
    {
       
    	return this.xPos;
    }
    
    /** Gets the y-coordinate of the player.
	 * @param No parameters.
	 * @return yPos - y-coordinate of the player.
	 */
    public double getyPos() 
    {
        return this.yPos; 	
    }
    
    public void setxPos(double new_xPos)
    {
    	this.xPos = new_xPos;
    	return; 
    }
    
    public void setyPos(double new_yPos)
    {
    	this.yPos = new_yPos;
    }
    
    
    /** Creates the player object.  
     * @param playerImagePath - the path to the file containing the image
     * of the player.
     */
	public Unit(String playerImagePath, double starting_X, double starting_Y) 
	throws SlickException
	{
		/* Initializing coordinates of the player. */
		xPos = starting_X; 
		yPos = starting_Y;
		/* Assigning the player and inverted player image. */
		unit_image = new Image(playerImagePath);
		unit_image_inverted = unit_image.getFlippedCopy(true, false); 
	}
	
	
	
	/** Render the player.
	 * @param g - the Slick graphics object used for drawing. 
	 * @param cam_minX - the minimum x-coordinate displayed on the 
	 * screen.
	 * @param cam_minY - the minimum y-coordinate displayed on the 
	 * screen.
	 * @return void.
	 */
	public void render(Graphics g, double cam_minX, double cam_minY)
	{
		/* Using translate to make sure the player is printed on 
		 * the screen. */
		g.translate(-(float)cam_minX, -(float)cam_minY);
		
		/* Draw the player on the screen based on the side (s)he is 
		 * facing. */
		if(this.facing_right)
		{
			unit_image.drawCentered((float)xPos, (float)yPos);
		}
		else
		{
			unit_image_inverted.drawCentered((float)xPos, (float)yPos);
		}		
	}
}
