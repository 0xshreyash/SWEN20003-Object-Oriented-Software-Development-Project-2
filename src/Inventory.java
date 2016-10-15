/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 */

import java.util.*; 

import org.newdawn.slick.SlickException;

/** Inventory for the Player */
public class Inventory 
{
	/** List of items */
	private ArrayList<Item> items;
	
    /** Creates an new array list to host the inventory
     */
    public Inventory() 
    {
		items = new ArrayList<>();
    }
    
    /**
     * adds item  to the arraylist of items
     * @param e
     */
    public void addItem(Item e)
    {
    	items.add(e);
    }
    
    /** Method for taking away item 
     * @param itemName is the name of the item
     */
    public void takeAwayItem(String itemName)
    throws SlickException
    {
    		for(Item item : items)
		    	if(item.getItemName().equals(itemName))
		    	{
		    		item.setCollected(true);
		    		
		    	}
    }

    /** 
     * @return the ArrayList of items
     */
    public ArrayList<Item> getItems() 
    {
        return items;
    }

   

}