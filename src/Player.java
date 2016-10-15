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

/** Player class, the class that we can control */
public class Player extends Unit implements Interactable
{

	/** Image of the panel for the player */
	private Image panel;
	
	/** true if the Player is attacking */
	private int attacking;
	
	/** true if the Player is talking */
	private int talking;
	
	/** Inventory of the player */
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
	
	/**
	 * Return inventory as an ArrayList
	 * @return inv - ArrayList
	 */
	public Inventory getInv() 
	{
		return inv;
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
			/* Respawning courtesy Elvira */
			this.setPos(Constant.respawn_X, Constant.respawn_Y);
			this.setHP(this.getMaxHP());
			this.setCoolDown(0);
			this.setDead(false);
		}
	}
	
	/**
	 * true if the player is talking 
	 * @return isTalking - boolean
	 */
	public boolean isTalking()
	{
		return (talking==1)?true:false;
	}
	
	/** 
	 * true if the player is attacking
	 * @return isAttacking - boolean
	 */
	public boolean isAttacking()
	{
		return (attacking==1)?true:false;
	}
	
	/**
	 * returns the items in the inventory of the player
	 * @return ArrayList of items that player has collected
	 */
	public ArrayList<Item> getItems() 
	{
	        return inv.getItems();
	}

	/**
	 * true if the player has the proposed item
	 * @param itemName - the item we want to check if the player
	 * has
	 * @return true if the player has the item
	 */
    public boolean hasItem(String itemName) 
    {
        for (Item trialItem : this.getItems())
        {
            if (trialItem.getItemName().equals(itemName))
            	return true;
        }
        return false;
    }

    /** 
     * take item away from player 
     * @param itemName - item to be taken away
     * @throws SlickException
     */
    public void takeAwayItem(String itemName) 
    throws SlickException 
    {
        inv.takeAwayItem(itemName);
    }
    
    /**
     * alias for take item
     * @param item - the item we want to take away
     * @throws SlickException
     */
    public void takeItem(Item item) 
    throws SlickException
    {
        inv.takeAwayItem(item.getItemName());
    }
    
    /**
     * Checks if other Interactable is within range 
     * of collision
     * @return true if other is within range.
     */
	@Override
	public boolean isWithinRange(Interactable other) 
	{
		
		return getDistance(other) <= collideRange;
	}

	/**
	 * Check if other is the same as this object
	 * @return true if the other is the same as this
	 */
	@Override
	public boolean isSame(Object other) 
	{
		return this == other;
	}

	/** 
	 * Update so that class successfully implements the interface
	 */
	@Override
	public void update(Map map, int delta) 
	{
		return;
		
	}
	
	/**
	 * @param g - Slick graphics container g
	 * @return void
	 */
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
	
	/**
	 * Take action on the other interactable
	 * @param other Interactable
	 */
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
				/* Make player adversary of the monster */
				((Monster)other).setAdversary(this);
				((Monster)other).setUnderAttack(true);
				((Monster)other).setDeltaSinceBeingAttacked(0);
				
				this.setCoolDown(this.getMaxCoolDown());
			}
			
		}
			
	}

	/**
	 * Check if the player is  dead 
	 * @return false if player is dead 
	 */
	@Override
	public boolean isActive() 
	{
		// TODO Auto-generated method stub
		return true;
	}
	
	/**
	 * Returns the panel
	 * @return the panel of the player
	 */
	public Image getPlayerPanel()
	{
		return this.panel;
	}
	
	/**
	 * Returns the tag of the Player
	 * @return the InteractorTag
	 */
	@Override
	public InteractorTag identify() {
		
		return InteractorTag.Player;
	}

	private float getDistance(Interactable other)
	{
        return (float)Math.sqrt(getPos().distanceSquared(other.getPos()));
    }
}
