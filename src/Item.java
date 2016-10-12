import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.Image;

// To-do: check for range
public abstract class Item extends Entity implements Interactable
{
	private Image itemImage;
	private String itemName;
	private boolean collected; 
	private float range;
	
	public Item(float starting_X, float starting_Y, String item_image, String item_name)
	throws SlickException
	{
		super(starting_X, starting_Y);
		itemImage = new Image(item_image);
		collected = false; 
		itemName = item_name; // Check this out. 

	
		
	}
	
	
	public void render(Graphics g, float cam_minX, float cam_minY)
	{
		if(this.getxPos() >= cam_minX && this.getyPos() >= cam_minY)
		{
			itemImage.drawCentered(this.getxPos(), this.getyPos());
		}
		
	}
	
	public boolean withinRange(Player player)
	{
		return true;
	}
	
	public Enum<?>[] getInteractors()
	{
		return Player;
	}
}