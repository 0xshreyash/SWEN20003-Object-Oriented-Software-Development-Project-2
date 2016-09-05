/* 433-294 Object Oriented Software Development

 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 */


import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Player 
{
	
	private Image player_image = null; 
	private Image player_image_flipped = null;
	
	private final double starting_X = 756; 
	private final double starting_Y = 684; 
	
	private static final double SPEED = 0.25;
	
	private double xPos = 0; 
	private double yPos = 0; 
	private boolean facing_right = true; 
	
    public double getxPos() 
    {
       
    	return this.xPos;
    }

    public double getyPos() 
    {
        return this.yPos;
    	
    }
    
    // See whether to get the paths in World or not
	public Player(String playerImagePath) 
	throws SlickException
	{
		this.xPos = starting_X; 
		this.yPos = starting_Y; 
		
		player_image = new Image(playerImagePath);
		player_image_flipped = player_image.getFlippedCopy(true, false); 
	}
	
	public void update_position(World world, double dir_x, double dir_y, int delta)
	{
		double new_xPos = this.xPos + dir_x*SPEED * delta; 
		double new_yPos = this.yPos + dir_y*SPEED * delta; 
		
		if(world.blocks(new_xPos, new_yPos) && !world.blocks(this.xPos, new_yPos))
		{
			this.yPos = new_yPos;  
		}
		else if(world.blocks(new_xPos, new_yPos) && !world.blocks(new_xPos, this.yPos))
		{
			this.xPos = new_xPos; 
		}
		else if(!world.blocks(new_xPos, new_yPos))
		{
			this.xPos = new_xPos;
			this.yPos = new_yPos; 
		}
		
		if(dir_x > 0)
		{
			this.facing_right = true; 
		}
		else if(dir_x < 0)
		{
			this.facing_right = false; 
		}
			
			
	}
	
	public void render(Graphics g, Camera cam)
	{
		float xOnScreen, yOnScreen;
		xOnScreen = (float)(this.xPos - cam.getMinX());
		yOnScreen = (float)(this.yPos - cam.getMinY());

		
		if(this.facing_right)
		{
					
			player_image.drawCentered(xOnScreen, yOnScreen);
		}
		else
		{
			player_image_flipped.drawCentered(xOnScreen, yOnScreen);
		}
		
	}



}
