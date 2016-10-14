/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 * 
 * This file contains the Player class which controls the player
 * in the program.
 */

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public abstract class Unit extends Entity
{
	private Image unit_image = null; 
	private Image unit_image_inverted = null;
	private int maxHP;
	private int HP; 
	private String name;
	private float speed;
	private  int maxDamage;
	private int maxCoolDown;
	private int coolDown; 
	private boolean facing_right = true;
	private boolean isDead = false; 
	
	/** Creates the Unit object.  
     */
	public Unit(String UnitImagePath, float starting_X, float starting_Y,
			int max_HP, float unit_speed, int max_Damage, int max_CoolDown, String unitName) 
	throws SlickException
	{
		
		super(starting_X, starting_Y);
		unit_image = new Image(UnitImagePath);
		unit_image_inverted = unit_image.getFlippedCopy(true, false);
		maxHP = max_HP; 
		speed = unit_speed; 
		maxDamage = max_Damage; 
		maxCoolDown = max_CoolDown; 
		name = unitName;
		HP = maxHP;
		
	}
	
	
	public void setHP(int hP) 
	{
		HP = hP;
	}
	
	public void setMaxHP(int newMaxHP) 
	{
		maxHP = newMaxHP;
	}
	
	public void setMaxDamage(int newMaxDamage) 
	{
		maxDamage = newMaxDamage;
	}
	
	public void setMaxCoolDown(int newMaxCoolDown)
	{
		
		maxCoolDown = newMaxCoolDown;
	}

	public void setSpeed(float newSpeed)
	{
		speed = newSpeed;
	}
	

	public void setCoolDown(int coolDown) 
	{
		if(coolDown >= 0)
			this.coolDown = coolDown;
		else
			this.coolDown = 0;
	}
	
	public void setName(String newName)
	{
		name = newName;
	}
	
	public void changeFacing()
	{
		facing_right = !facing_right;
	}
	
	public void face_right()
	{
		facing_right = true;
		
	}
	
	public void face_left()
	{
		facing_right = false;
	}
	
	
	public void setDead(boolean isDead) 
	{
		this.isDead = isDead;
		
		if(!isDead)
		{
			HP = maxHP;
		}
	}
	
	public void setDead()
	{
		if(this.getHP() <= 0)
			this.isDead = true;
		else
			this.isDead = false;
		
		return;
	}
		
	public boolean isDead() 
	{
		return isDead;
	}
	
	public boolean isFacingRight()
	{
		return facing_right;
	}
	
	

	public String getName()
	{
		return name;
	}
	
	public int getCoolDown()
	{
		return coolDown;
	}
	
	public int getHP() 
	{
		return HP;
	}

	public int getMaxHP() 
	{
		return maxHP;
	}

	public float getSpeed() 
	{
		return speed;
	}

	public int getMaxDamage() 
	{
		return maxDamage;
	}

	public int getMaxCoolDown() 
	{
		return maxCoolDown;
	}
	
	public Image getImage()
	{
		return unit_image;
	}
	
	public Image getImageInverted()
	{
		return unit_image_inverted;
	}
	
	

	/** Updates the position of the player in order to render it.
	 * @param map - The Map object we use to see if the tile is
	 * blocking or not. 
	 * @param dir_x - the direction of movement in the x-direction.
	 * @param dir_y - the direction of movement in the y-direction.
	 * @param delta - the time elapsed since the last update.
	 * @return - void.
	 */
	//public void update(Map map, float dir_x, float dir_y, int delta)
	//{
		/* Prospective x and y-coordinates computed */
		/*float new_xPos  = this.getxPos() + dir_x*speed* delta; 
		float new_yPos =  this.getyPos() + dir_y*speed* delta;*/ 
		
		/* Check for blocking of the player by certain tiles and 
		 * halt movement if a certain tile blocks. 
		 */
		/* Update only the yPos if the xPos caused the blocking. */ 
		//if(map.blocks(new_xPos, new_yPos) && !map.blocks(this.getxPos(), new_yPos))
		//{
			
			/* Making sure the new y-position is on the game board. */
			//if(!((int)Math.floor(new_yPos) <= Constant.min_Y
			 //|| (int)Math.ceil(new_yPos) >= Constant.gameheight))
			//{
				//this.setxPos(new_yPos); 
			//}	 
		//}
		/* Update only the xPos if the yPos is causing the blocking. */
		//else if(map.blocks(new_xPos, new_yPos) && !map.blocks(new_xPos, getyPos()))
		//{
			
			/* Making sure the new x-position is on the game board. */
			//if(!((int)Math.floor(new_xPos) <= Constant.min_X
			 //|| (int)Math.ceil(new_xPos) >= Constant.gamewidth))
			//{
				//this.setxPos(new_xPos);; 
			//}
		//}
		/* Update both if none of the xPos and yPos cause blocking. */
		//else if(!map.blocks(new_xPos, new_yPos))
		//{
			/* Making sure the new x-position is on the game board. */
			//if(!((int)Math.floor(new_xPos) <= Constant.min_X
			 //|| (int)Math.ceil(new_xPos) >= Constant.gamewidth))
			//{
				//this.setxPos(new_xPos);; 
			//}
			/* Making sure the new y-position is on the game board. */
			//if(!((int)Math.floor(new_yPos) <= Constant.min_Y
			 //|| (int)Math.ceil(new_yPos) >= Constant.gameheight))
			//{
				//this.setxPos(new_yPos);
			//}	
		//}	
		/* Check which side the player is facing. */
		//if(dir_x > 0)
		//{
			//this.facing_right = true; 
		//}
		//else if(dir_x < 0)
		//{
			//this.facing_right = false; 
		//}	
	//}
	
	
	//public void render(Graphics g, float cam_minX, float cam_minY)
	//{
		/* Using translate to make sure the player is printed on 
		 * the screen. */
		//g.translate(-(float)cam_minX, -(float)cam_minY);
		
		/* Draw the player on the screen based on the side (s)he is 
		 * facing. */
		/*if (this.getxPos() >= cam_minX && this.getyPos() >= cam_minY)
		{
			if(this.facing_right)
			{
				unit_image.drawCentered(this.getxPos(), this.getyPos());
			}
			else
			{
				unit_image_inverted.drawCentered(this.getxPos(), this.getyPos());
			}	
		}
	}*/
	
	
  /* public float distance(float x2, float y2)
    {
    	return (float)(Math.sqrt((float)(Math.pow(this.getxPos()-x2, 2) + 
    			Math.pow(this.getyPos()-y2, 2))));
    }*/
	
	public void renderHealthBar(Graphics g)
	{
        Color LABEL = new Color(0.9f, 0.9f, 0.4f);          // Gold
        Color VALUE = new Color(1.0f, 1.0f, 1.0f);          // White
        Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);   // Black, transp
        Color BAR = new Color(0.8f, 0.0f, 0.0f, 0.8f);      // Red, transp
        
        int healthBarHeight = Constant.BAR_HEIGHT;
        int healthBarWidth = Math.max(g.getFont().getWidth(name) + Constant.ADD_TO_FONT_WIDTH, -Constant.BAR_Y_OFFSET);
        
        float adj_x = this.getxPos() + Constant.BAR_X_OFFSET;
        float adj_y = this.getyPos() + Constant.BAR_Y_OFFSET;
    
        g.setColor(BAR_BG);
        g.fillRect(adj_x, adj_y, healthBarWidth, healthBarHeight);
        
        float health_percentage = ((float)(this.getHP())/this.getMaxHP())*100f;
        g.setColor(BAR);
        g.fillRect(adj_x, adj_y, health_percentage, healthBarHeight);
		
     
        g.setColor(VALUE);
        g.drawString(name, adj_x, adj_y);
	}

}
