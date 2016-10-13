
import java.util.*;

import org.newdawn.slick.SlickException;

/**
 * 
 */
public class Inventory 
{

	private ArrayList<Item> items;
    /**
     * Default constructor
     */
    public Inventory() 
    {
    	items = new ArrayList<>();
    }
    
    public void addItem(Item e)
    {
    	items.add(e);
    }
    
    public void takeItem(String itemName)
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
     * @return
     */
    public ArrayList<Item> getItems() 
    {
        
        return items;
    }

   

}