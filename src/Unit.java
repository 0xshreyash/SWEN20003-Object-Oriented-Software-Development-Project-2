/* SWEN20003 Object Oriented Software Development  
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 * 
 * This file contains the Unit class which controls the player
 * in the program.
 */

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public abstract class Unit extends Entity
{
	/** Let us define the instance variables for this class
	 */
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
	
	/** Creates a unit
	 * @param UnitImagePath directory where image is stored
	 * @param starting_X starting x position
	 * @param starting_Y starting y position
	 * @param max_HP maximum hit points
	 * @param unit_speed speed of the units in pixels/ms
	 * @param max_Damage maximum damage of the unit
	 * @param max_CoolDown maximum cooldown time of the unit
	 * @param unitName name of the unit
	 * @throws SlickException
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
	
	/** HP setter
	 * @param hP
	 */
	public void setHP(int hP) 
	{
		HP = hP;
	}
	
	/** Max hit points setter
	 * @param newMaxHP
	 */
	public void setMaxHP(int newMaxHP) 
	{
		maxHP = newMaxHP;
	}
	
	/** max damage setter
	 * @param newMaxDamage
	 */
	public void setMaxDamage(int newMaxDamage) 
	{
		maxDamage = newMaxDamage;
	}
	
	/** max cooldown setter
	 * @param newMaxCoolDown
	 */
	public void setMaxCoolDown(int newMaxCoolDown)
	{
		
		maxCoolDown = newMaxCoolDown;
	}

	/** Speed setter
	 * @param newSpeed
	 */
	public void setSpeed(float newSpeed)
	{
		speed = newSpeed;
	}
	
	/** Cooldown setter with validation check to set cooldown only if it is positive
	 * @param coolDown
	 */
	public void setCoolDown(int coolDown) 
	{
		if(coolDown >= 0)
			this.coolDown = coolDown;
		else
			this.coolDown = 0;
	}
	
	/** Name setter
	 * @param newName
	 */
	public void setName(String newName)
	{
		name = newName;
	}
	
	/** Setting the flipped image if player facing in different direction
	 */
	public void changeFacing()
	{
		facing_right = !facing_right;
	}
	
	/** Setting boolean for facing right
	 */
	public void face_right()
	{
		facing_right = true;
		
	}
	
	/** Setting boolean for facing left
	 */
	public void face_left()
	{
		facing_right = false;
	}
	
	/** Checking if unit is dead
	 * @param isDead boolean for life state
	 */
	public void setDead(boolean isDead) 
	{
		this.isDead = isDead;
		
		if(!isDead)
		{
			HP = maxHP;
		}
	}
	
	/** Setting life state of the unit
	 */
	public void setDead()
	{
		if(this.getHP() <= 0)
			this.isDead = true;
		else
			this.isDead = false;
		
		return;
	}
		
	/** getter for life state
	 * @return boolean of life state
	 */
	public boolean isDead() 
	{
		return isDead;
	}
	
	/** Getter for checking if facing right or not
	 * @return boolean if facing right or not
	 */
	public boolean isFacingRight()
	{
		return facing_right;
	}
	
	
	/** Gets the name of the unit
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	
	/** Gets the cooldown
	 * @return cooldown
	 */
	public int getCoolDown()
	{
		return coolDown;
	}
	
	/** Getter for HP
	 * @return HP
	 */
	public int getHP() 
	{
		return HP;
	}

	/** Getter for max HP
	 * @return maximum HP
	 */
	public int getMaxHP() 
	{
		return maxHP;
	}

	/** Getter for the unit speed 
	 * @return speed
	 */
	public float getSpeed() 
	{
		return speed;
	}

	/** Getter for the max damage
	 * @return max damage
	 */
	public int getMaxDamage() 
	{
		return maxDamage;
	}

	/** Getter for the max cooldown
	 * @return max cooldown
	 */
	public int getMaxCoolDown() 
	{
		return maxCoolDown;
	}
	
	/** Getter for the image of the unit
	 * @return the unit image
	 */
	public Image getImage()
	{
		return unit_image;
	}
	
	/** Getting the inverted image
	 * @return iverted image
	 */
	public Image getImageInverted()
	{
		return unit_image_inverted;
	}
	
	/** Renders the health bar of the player
	 * @param g is the graphic container for slick
	 */
	public void renderHealthBar(Graphics g)
	{
		/* setting the colour for the bar */
        Color VALUE = new Color(1.0f, 1.0f, 1.0f);          // White
        Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);   // Black, transp
        Color BAR = new Color(0.8f, 0.0f, 0.0f, 0.8f);      // Red, transp
        
        //bar dimensions
        int healthBarHeight = Constant.BAR_HEIGHT;
        int healthBarWidth = Math.max(g.getFont().getWidth(name) + Constant.ADD_TO_FONT_WIDTH, -Constant.BAR_Y_OFFSET);
        
        float adj_x = this.getxPos() + Constant.BAR_X_OFFSET;
        float adj_y = this.getyPos() + Constant.BAR_Y_OFFSET;
    
        //filling in the bar with the health of the player and also setting the colour
        g.setColor(BAR_BG);
        g.fillRect(adj_x, adj_y, healthBarWidth>Constant.HEALTH_BAR_WIDTH?healthBarWidth:Constant.HEALTH_BAR_WIDTH, healthBarHeight);
        // max in order to mae sure all of the red has black beneath it
        
        float health_percentage = ((float)(this.getHP())/this.getMaxHP())*100f;
        g.setColor(BAR);
        g.fillRect(adj_x, adj_y, health_percentage, healthBarHeight);
		
        float text_x = adj_x + (Constant.HEALTH_BAR_WIDTH  - g.getFont().getWidth(this.getName()))/2;
        float text_y = adj_y;
        g.setColor(VALUE);
        g.drawString(name,text_x, adj_y);
	}

}
