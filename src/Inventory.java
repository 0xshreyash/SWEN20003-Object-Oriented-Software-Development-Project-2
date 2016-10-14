
import java.util.*; 

import org.newdawn.slick.SlickException;

/**
 * 
 */
public class Inventory 
{
	/** List of items */
	private ArrayList<Item> items;
	
    /**
     * 
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
    
    public void takeAwayItem(String itemName)
    throws SlickException
    {
    		Item toAdd = null; 
	    	if(itemName.equals(Constant.ELIXIR))
	    	{
	    		toAdd = new Elixir();
	    		
	    	}
	    	else if(itemName.equals(Constant.SWORD))
	    	{
	    		toAdd = new Sword();
	    	}
	    	else if(itemName.equals(Constant.TOME))
	    	{
	    		toAdd = new Tome();
	    	}
	    	else if(itemName.equals(Constant.AMULET))
	    	{
	    		toAdd = new Amulet();
	    	}
	    	int index = items.indexOf(toAdd);
	    	if(index != -1)
	    	{
	    		items.get(index).setCollected(true);
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