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

public class Player extends Character
{
	/**************** Attributes *********************/
	
	
	/***************** Methods ***********************/
	
 
    /** Creates the player object.  
     * @param playerImagePath - the path to the file containing the image
     * of the player.
     */
	public Player(String playerImagePath) 
	throws SlickException
	{
		super(playerImagePath);
	}
	
	/** Will kill enemies. */
	public void Kill()
	throws SlickException
	{
		String s = "Hi";
	
	}

}
