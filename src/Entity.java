/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 * 
 * This file contains the Player class which controls the player
 * in the program.
 */
 
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/** Entity class as a general purpose class */
public abstract class Entity
{
	/**************** Attributes *********************/
	
	/** Current coordinates of the player.*/
	private Vector2f pos;
	
	/***************** Methods ***********************/
	
    
    /** Creates the player object.  
     * @param playerImagePath - the path to the file containing the image
     * of the player.
     */
	public Entity(float starting_X, float starting_Y) 
	throws SlickException
	{
		/* Initializing coordinates of the player. */
		pos = new Vector2f(starting_X, starting_Y); 
	
		/* Assigning the player and inverted player image. */
		/*unit_image = new Image(playerImagePath);
		unit_image_inverted = unit_image.getFlippedCopy(true, false); */
	}
	
	
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
    
    /** Get the position of the player
     * @return - position of the player
     */
    public Vector2f getPos()
    {
    	return pos;
    }
    
    /** Sets the x-coordinate of the player
     * @param new_xPos - the new x-coordinate of the player
     * @return - void
     */
    public void setxPos(float new_xPos)
    {
    	
    	pos.set(new_xPos, pos.getY());
    }
    
    /** Sets the y-coordinate of the player
     * @param new_xPos - the new y-coordinate of the player
     * @return - void
     */
    public void setyPos(float new_yPos)
    {
    	pos.set(pos.getX(), new_yPos);
    }
    
    /** Sets the position of the player
     * @param new_pos - the new position of the player
     * @return - void
     */
    public void setPos (Vector2f new_pos)
    {
    	if (this.pos == null)
    		pos = new Vector2f(new_pos);
    	else
    		pos.set(new_pos);
    	
    	return;
    }
    
    /** Sets the position of the player
     * @param new_xPos - the new x-coordinate of the player
     * @param new_yPos - the new y-coordinate of the player
     * @return - void
     */
    public void setPos(float new_xPos, float new_yPos)
    {
    	if (this.pos == null)
    		pos = new Vector2f(new_xPos, new_yPos);
    	else
    		pos.set(new_xPos, new_yPos);
    	
    	return;
    }
	
}
