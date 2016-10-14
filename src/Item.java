/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 */

import org.newdawn.slick.Graphics; 
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;

 
public abstract class Item extends Entity implements Interactable
{
	/** Defining the instance variable used this  class
	 */
	private Image itemImage;
	private String itemName;
	private boolean collected; 
	
	/** This is the constructor for this class
	 * @param starting_X starting x position
	 * @param starting_Y startingy position
	 * @param item_image the image of the item
	 * @param item_name the name of the item
	 * @throws SlickException
	 */
	public Item(float starting_X, float starting_Y, String item_image, String item_name)
	throws SlickException
	{
		super(starting_X, starting_Y);
		itemImage = new Image(item_image);
		collected = false; 
		itemName = item_name; // Check this out. 	
	}
	
	/** Getter for the item name
	 * @return the item name
	 */
	public String getItemName() 
	{
		return this.itemName;
	}
	
	/** Checks if the item is collected
	 * @return boolean of the above condition
	 */
	public boolean getCollected()
	{
		return collected;
	}
	
	/** Setter for the collection state of the object
	 * @param change the new state 
	 */
	public void setCollected(boolean change)
	{
		collected = change;
		
	}
	
	/** Renders the item
	 * @param g the graphics container
	 * @param offScreenX x position of the object on the screen
	 * @param offScreenY y position of the object on the screen
	 */
	public void render(Graphics g, float offScreenX, float offScreenY)
	{
		if(!collected)
			itemImage.drawCentered(this.getxPos(), this.getyPos());
		else
			itemImage.drawCentered(offScreenX, offScreenY);
	}
	
	/** Checking if the item is an interactable
	 * @param other an interactable
	 * @return whether above condition is true
	 */
	public boolean isInteractor(Interactable other)
	{
	    	return other instanceof Player;
	}
	
	
	

	@Override
	/** Checks if the item is in range
	 * @param other the item to be checked
	 */
	public boolean isWithinRange(Interactable other) 
	{
		return getDistance(other) <= collideRange;
		
	}

	@Override
	/** Checking if an item is the same as the other
	 */
	public boolean isSame(Object other) 
	{
		if(other == null || other.getClass() != this.getClass())
			return false;
		return ((Item)other).getItemName().equals(this.itemName);
	}
	
	/** Checking if the name is the same
	 * @param otherName the name to be checked
	 * @return whether the above condition is true or falses
	 */
	public boolean isSame(String otherName) 
	{
		if(otherName == null)
			return false;
		return (otherName).equals(this.itemName);
	}

	@Override
	/** Update world to show the new state
	 */
	public void update(Map map, float dir_x, float dir_y, int delta, int attack, int talk) 
	{
		return;
	}

	@Override
	/** Overloaded update method
	 */
	public void update(Map map, int delta) 
	{
		return;
		
	}

	@Override
	/** Renders the item
	 */
	public void render(Graphics g) 
	{
		if(!collected)
		{
			itemImage.drawCentered(this.getxPos(), this.getyPos());
		}
		
	}

	@Override
	/** Checking if the object is collected or not
	 */
	public boolean isActive() 
	{
		return !collected;
	}
	
	/** Getting the distance of the object from another interactable
	 * @param other the object the distance needs to be calculated from
	 * @return the distance
	 */
	private float getDistance(Interactable other)
	{
		return (float)Math.sqrt(getPos().distanceSquared(other.getPos()));
	}
	@Override
	/** Identifying the object type found in the world
	 */
	public InteractorTag identify() 
	{
		
		return InteractorTag.Item;
	}
	
}