import org.newdawn.slick.Graphics; 
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;

// To-do: check for range. 
// To-do: the getInteractors() method. 
public abstract class Item extends Entity implements Interactable
{
	private Image itemImage;
	private String itemName;
	private boolean collected; 
	
	public Item(float starting_X, float starting_Y, String item_image, String item_name)
	throws SlickException
	{
		super(starting_X, starting_Y);
		itemImage = new Image(item_image);
		collected = false; 
		itemName = item_name; // Check this out. 	
	}
	
	public String getItemName() 
	{
		return this.itemName;
	}
	
	public boolean getCollected()
	{
		return collected;
	}
	
	public void setCollected(boolean change)
	{
		collected = change;
		
	}
	
	public void render(Graphics g, float offScreenX, float offScreenY)
	{
		if(!collected)
			itemImage.drawCentered(this.getxPos(), this.getyPos());
		else
			itemImage.drawCentered(offScreenX, offScreenY);
	}
	
	public boolean isInteractor(Interactable other)
	{
	    	return other instanceof Player;
	}
	
	


	@Override
	public boolean isWithinRange(Interactable other) 
	{
		return getDistance(other) <= collideRange;
		
	}

	@Override
	public boolean isSame(Object other) 
	{
		if(other == null || other.getClass() != this.getClass())
			return false;
		return ((Item)other).getItemName().equals(this.itemName);
	}
	
	public boolean isSame(String otherName) 
	{
		if(otherName == null)
			return false;
		return (otherName).equals(this.itemName);
	}

	@Override
	public void update(Map map, float dir_x, float dir_y, int delta, int attack, int talk) 
	{
		return;
	}

	@Override
	public void update(Map map, int delta) 
	{
		return;
		
	}

	@Override
	public void render(Graphics g) 
	{
		if(!collected)
		{
			itemImage.drawCentered(this.getxPos(), this.getyPos());
		}
		
	}

	@Override
	public boolean isActive() 
	{
		return !collected;
	}
	
	private float getDistance(Interactable other)
	{
		return (float)Math.sqrt(getPos().distanceSquared(other.getPos()));
	}
	@Override
	public InteractorTag identify() 
	{
		
		return InteractorTag.Item;
	}
	
}