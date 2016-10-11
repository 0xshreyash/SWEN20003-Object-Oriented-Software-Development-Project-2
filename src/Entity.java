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
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Entity
{
	/**************** Attributes *********************/
	
	/** Image of the player. */
	//private Image unit_image = null; 
	
	/** Inverted image of the player. */
	//private Image unit_image_inverted = null;
	
	/** Starting coordinates of the player. */
	/** Starting x-coordinate of the player. */

	

	
	/** Current coordinates of the player.*/
	private Vector2f pos;
	
	/***************** Methods ***********************/
	
	/** Gets the x-coordinate of the player.
	 * @param No parameters.
	 * @return xPos - x-coordinate of the player.
	 */
    public float getxPos() 
    {
       
    	return pos.getX();
    }
    
    /** Gets the y-coordinate of the player.
	 * @param No parameters.
	 * @return yPos - y-coordinate of the player.
	 */
    public float getyPos() 
    {
    	return pos.getY();
    }
    
    public Vector2f getPos()
    {
    	return pos;
    }
    
    public void setxPos(float new_xPos)
    {
    	
    	pos.set(new_xPos, pos.getY());
    }
    
    public void setyPos(float new_yPos)
    {
    	pos.set( pos.getX(), new_yPos);
    }
    
    public void setPos (Vector2f new_pos)
    {
    	pos.set(new_pos);
    }
    
    
    /** Creates the player object.  
     * @param playerImagePath - the path to the file containing the image
     * of the player.
     */
	public Entity(float starting_X, float starting_Y) 
	throws SlickException
	{
		/* Initializing coordinates of the player. */
		pos.set(starting_X, starting_Y); 
	
		/* Assigning the player and inverted player image. */
		/*unit_image = new Image(playerImagePath);
		unit_image_inverted = unit_image.getFlippedCopy(true, false); */
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
		
		
		/* Draw the player on the screen based on the side (s)he is 
		 * facing. */
		/*if(this.facing_right)
		{
			unit_image.drawCentered((float)xPos, (float)yPos);
		}
		else
		{
			unit_image_inverted.drawCentered((float)xPos, (float)yPos);
		}*/	
	}
}
