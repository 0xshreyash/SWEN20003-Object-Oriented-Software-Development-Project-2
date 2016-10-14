/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 * 
 * This file contains the Player class which controls the player
 * in the program.
 */

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player extends Unit implements Interactable
{

	private Image panel;
	
	private int attacking;
	
	private int talking;
	
	private Inventory inv; 
    /** Creates the player object.  
     * @param playerImagePath - the path to the file containing the image
     * of the player.
     */
	public Player() 
	throws SlickException
	{
		//String UnitImagePath, float starting_X, float starting_Y,
		//int max_HP, float unit_speed, int max_Damage, int max_CoolDown
		super(Constant.PLAYER_PATH, Constant.player_starting_X, Constant.player_starting_Y, 
				Constant.PlayerHP, Constant.PLAYER_SPEED, Constant.PlayerDamage, 
				Constant.PlayerCooldown, Constant.PLAYER);
		inv = new Inventory();
		this.panel = new Image(Constant.PANEL_PATH);
		this.setCoolDown(0);
		
	}
	

	
	/** Updates the position of the player in order to render it.
	 * @param map - The Map object we use to see if the tile is
	 * blocking or not. 
	 * @param dir_x - the direction of movement in the x-direction.
	 * @param dir_y - the direction of movement in the y-direction.
	 * @param delta - the time elapsed since the last update.
	 * @return - void.
	 */
	public void update(Map map, float dir_x, float dir_y, int delta, int attack, int talk)
	{
		this.setDead();
		this.setCoolDown(this.getCoolDown() - delta);
		/* Prospective x and y-coordinates computed */
		float new_xPos = this.getxPos() + dir_x*this.getSpeed()*delta; 
		float new_yPos = this.getyPos() + dir_y*this.getSpeed()* delta; 
		
		
		/* Check for blocking of the player by certain tiles and 
		 * halt movement if a certain tile blocks. 
		 */
		/* Update only the yPos if the xPos caused the blocking. */ 
		if(map.blocks(new_xPos, new_yPos) && !map.blocks(this.getxPos(), new_yPos))
		{
			
			/* Making sure the new y-position is on the game board. */
			if(!((int)Math.floor(new_yPos) <= Constant.min_Y
			 || (int)Math.ceil(new_yPos) >= Constant.gameheight))
			{
				this.setyPos(new_yPos); 
			}	 
		}
		/* Update only the xPos if the yPos is causing the blocking. */
		else if(map.blocks(new_xPos, new_yPos) && !map.blocks(new_xPos, this.getyPos()))
		{
			
			/* Making sure the new x-position is on the game board. */
			if(!((int)Math.floor(new_xPos) <= Constant.min_X
			 || (int)Math.ceil(new_xPos) >= Constant.gamewidth))
			{
				this.setxPos(new_xPos); 
			}
		}
		/* Update both if none of the xPos and yPos cause blocking. */
		else if(!map.blocks(new_xPos, new_yPos))
		{
			/* Making sure the new x-position is on the game board. */
			if(!((int)Math.floor(new_xPos) <= Constant.min_X
			 || (int)Math.ceil(new_xPos) >= Constant.gamewidth))
			{
				this.setxPos(new_xPos); 
			}
			/* Making sure the new y-position is on the game board. */
			if(!((int)Math.floor(new_yPos) <= Constant.min_Y
			 || (int)Math.ceil(new_yPos) >= Constant.gameheight))
			{
				this.setyPos(new_yPos); 
			}	
		}	
		/* Check which side the player is facing. */
		if(dir_x > 0)
		{
			this.face_right();
		}
		else if(dir_x < 0)
		{
			this.face_left(); 
		}
		
		attacking = attack;
		talking = talk;
		
		if(this.isDead())
		{
			this.setPos(Constant.player_starting_X, Constant.player_starting_Y);
			this.setHP(this.getMaxHP());
			this.setCoolDown(0);
			this.setDead(false);
		}
	}
	
	
	public boolean isTalking()
	{
		return (talking==1)?true:false;
	}
	
	public boolean isAttacking()
	{
		return (attacking==1)?true:false;
	}
	
	public ArrayList<Item> getItems() 
	{
	        return inv.getItems();
	}

    public boolean hasItem(String itemName) 
    {
        for (Item trialItem : this.getItems())
        {
            if (trialItem.equals(itemName))
            	return true;
        }
        return false;
    }

    public void takeItem(String itemName) 
    throws SlickException 
    {
        inv.takeItem(itemName);
    }

    public void takeItem(Item item) 
    {
        inv.addItem(item);
    }

	@Override
	public boolean isWithinRange(Interactable other) 
	{
		
		return getDistance(other) <= collideRange;
	}

	@Override
	public boolean isSame(Object other) 
	{
		return false;
	}

	@Override
	public void update(Map map, int delta) 
	{
		return;
		
	}

	@Override
	public void render(Graphics g) 
	{
		if(this.isFacingRight())
			this.getImage().drawCentered(this.getxPos(), this.getyPos());
		else
			this.getImageInverted().drawCentered(this.getxPos(), this.getyPos());
		
		return;
	}
	
	/* Player has a different panel */
	@Override
	public void renderHealthBar(Graphics g)
	{
		return;
	}
	
	@Override
	public void action(Interactable other)
	{
		if((other.identify() == InteractorTag.MonsterAggressive || 
				other.identify() == InteractorTag.MonsterPassive)
				&& this.getCoolDown() <= 0)
		{
			if(this.isAttacking())
			{
				int damage = (int)(Math.random()*this.getMaxDamage());
				((Unit)other).setHP(((Unit)other).getHP() - 
						(int)(damage));
				System.out.println("Attacked with damage:" + damage + " " + ((Unit)other).getHP());
				
				((Monster)other).setAdversary(this);
				((Monster)other).setUnderAttack(true);
				((Monster)other).setDeltaSinceBeingAttacked(0);
				
				this.setCoolDown(this.getMaxCoolDown());
			}
			
		}
			
	}

	@Override
	public boolean isActive() 
	{
		// TODO Auto-generated method stub
		return true;
	}
	
	public Image getPlayerPanel()
	{
		return this.panel;
	}

	@Override
	public InteractorTag identify() {
		
		return InteractorTag.Player;
	}

	private float getDistance(Interactable other)
	{
        return (float)Math.sqrt(getPos().distanceSquared(other.getPos()));
    }
}
