/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 */

import java.util.*; 

import org.newdawn.slick.SlickException;


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
    		Item toTake = null; 
	    	if(itemName.equals(Constant.ELIXIR))
	    	{
	    		toTake = new Elixir();
	    		
	    	}
	    	else if(itemName.equals(Constant.SWORD))
	    	{
	    		toTake = new Sword();
	    	}
	    	else if(itemName.equals(Constant.TOME))
	    	{
	    		toTake = new Tome();
	    	}
	    	else if(itemName.equals(Constant.AMULET))
	    	{
	    		toTake = new Amulet();
	    	}
	    	int index = items.indexOf(toTake);
	    	if(index != -1)
	    	{
	    		items.get(index).setCollected(false);
	    		items.remove(index);	
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