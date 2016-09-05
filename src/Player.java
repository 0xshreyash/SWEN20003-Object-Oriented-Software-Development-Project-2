/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * 
 * This file contains the Player class which controls the player
 * in the program.
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Player 
{
	/**************** Attributes *********************/
	
	/** Image of the player. */
	private Image player_image = null; 
	/** Inverted image of the player. */
	private Image player_image_inverted = null;
	
	/** Starting coordinates of the player. */
	/** Starting x-coordinate of the player. */
	private static final double starting_X = 756; 
	/** Starting y-coordinate of the player. */
	private static final double starting_Y = 684; 
	
	/** Speed of the player. */
	private static final double SPEED = 0.25;
	
	/** Current coordinates of the player.*/
	/** Starting x-coordinates of the player. */
	private double xPos = 0; 
	/** Starting y-coordinates of the player. */
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
    
    /** Creates the player object.  
     * @param playerImagePath - the path to the file containing the image
     * of the player.
     */
	public Player(String playerImagePath) 
	throws SlickException
	{
		/* Initializing coordinates of the player. */
		this.xPos = starting_X; 
		this.yPos = starting_Y; 
		
		/* Assigning the player and inverted player image. */
		player_image = new Image(playerImagePath);
		player_image_inverted = player_image.getFlippedCopy(true, false); 
	}
	
	/** Updates the position of the player in order to render it.
	 * @param world - The world object we use to see if the tile is
	 * blocking or not. 
	 * @param dir_x - the direction of movement in the x-direction.
	 * @param dir_y - the direction of movement in the y-direction.
	 * @param delta - the time elapsed since the last update.
	 * @return - void.
	 */
	public void update_position(World world, double dir_x, double dir_y, int delta)
	{
		
		double new_xPos = this.xPos + dir_x*SPEED * delta; 
		double new_yPos = this.yPos + dir_y*SPEED * delta; 
		
		/* Implement the sliding feature. */
		
		/* Only update the yPos if the xPos caused the blocking. */ 
		if(world.blocks(new_xPos, new_yPos) && !world.blocks(this.xPos, new_yPos))
		{
			this.yPos = new_yPos;  
		}
		/* Update the xPos if the yPos is causing the blocking. */
		else if(world.blocks(new_xPos, new_yPos) && !world.blocks(new_xPos, this.yPos))
		{
			this.xPos = new_xPos; 
		}
		/* Update both if none of the xPos and yPos cause blocking. */
		else if(!world.blocks(new_xPos, new_yPos))
		{
			this.xPos = new_xPos;
			this.yPos = new_yPos; 
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
	
	/** Render the player.
	 * @param g - the Slick graphics object used for drawing. 
	 * @param cam - the Camera object that follows the player. 
	 * @return void.
	 */
	public void render(Graphics g, Camera cam)
	{
		/* Using translate to make sure the player is printed on 
		 * the screen. */
		g.translate(-(float)cam.getMinX(), -(float)cam.getMinY());
		
		/* Draw the player on the screen based on the side (s)he is 
		 * facing. */
		if(this.facing_right)
		{
			player_image.drawCentered((float)xPos, (float)yPos);
		}
		else
		{
			player_image_inverted.drawCentered((float)xPos, (float)yPos);
		}
		
	}



}
