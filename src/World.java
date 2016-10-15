/* SWEN20003 Object Oriented Software Development  
 * RPG Game Engine
 * Author: <Shreyash Patodia> <spatodia>
 * Student Number : 767336.
 * Email: spatodia@student.unimelb.edu.au
 * 
 * This file contains the World class for our game. 
 */

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;  
import org.newdawn.slick.SlickException;



/** Represents the entire game world.
 * (Designed to be instantiated just once for the whole game).
 */

public class World
{
	/**************** Attributes *********************/
	
	


	/** List of interactables */
	private ArrayList<Interactable> interactables;
	
	/** The number of extra tiles we need in each direction */
	private int extra_tiles = 2; 
	
	/** The map for our game. */
	private Map map = null;
	
	/** The camera that follows the player. */
	private Camera cam = null;
	
	private Player player = null; 


	/***************** Methods ***********************/
	
    /** Create a new World object. */
    public World()
    throws SlickException
    {
    	/* Define the objects in the map. */
    	this.interactables = new ArrayList<>();
    	setUpInteractables();
    	this.cam = new Camera(Constant.screenwidth, Constant.screenheight); 
    	this.map = new Map(Constant.MAP, Constant.ASSETS); 
    	for(Interactable in : interactables)
    	{
    		if(in.identify() == Interactable.InteractorTag.Player)
    		{
    			
    			cam.followUnit((Player)in);
    			player = (Player)in;
    		}
    	}	
    }
    
    /**
     * Initializes the interactables
     * @throws SlickException
     */
    public void setUpInteractables()
    throws SlickException
    {
    	Player pl = new Player();
    	interactables.add(pl); 
    	int i;
    	
    	/* Passive Monsters */
    	for(i = 0; i < Constant.NumberOfBats; i++)
    	{
    	
    		this.interactables.add(new GiantBat(Constant.PassiveStartingX[i], 
    				Constant.PassiveStartingY[i]));
    	}
    	int totalAggressive = Constant.NumberOfBandits + Constant.NumberOfDraelic
    			+ Constant.NumberOfSkeleton + Constant.NumberOfZombies;
    	
    	/* Aggressive Monsters */
    	for(i = 0; i < totalAggressive; i++)
    	{
    		if(i < Constant.NumberOfZombies)
    		{
    			interactables.add(new Zombie(Constant.AggressiveStartingX[i],
    					Constant.AggressiveStartingY[i]));
    		}
    		else if(i < Constant.NumberOfBandits + Constant.NumberOfZombies)
    		{
    			interactables.add(new Bandit(Constant.AggressiveStartingX[i],
    					Constant.AggressiveStartingY[i]));
    		}
    		else if(i < Constant.NumberOfBandits + Constant.NumberOfZombies  +
    				Constant.NumberOfSkeleton)
    		{
    			interactables.add(new Skeleton(Constant.AggressiveStartingX[i],
    					Constant.AggressiveStartingY[i]));
    		}
    
    		else
    		{
    			interactables.add(new Draelic(Constant.AggressiveStartingX[i],
    					Constant.AggressiveStartingY[i]));
    			//break;

    		}
    		
    	}
    	
    	/* Villagers */
    	interactables.add(new PrinceAldric());
    	interactables.add(new Elvira());
    	interactables.add(new Garth());
    	
    	/* Items */
    	interactables.add(new Amulet());
    	interactables.add(new Sword());
    	interactables.add(new Tome());
    	interactables.add(new Elixir());
    	
 
    }
    
    /** Update the game state for a frame.
     * @param dir_x The player's movement in the x axis (-1, 0 or 1).
     * @param dir_y The player's movement in the y axis (-1, 0 or 1).
     * @param delta Time passed since last frame (milliseconds).
     * @return void.
     */
    public void update(int dir_x, int dir_y, int delta, int attack, int talk)
    throws SlickException
    {
    	/* Update all interactables except player */
    	for(Interactable in : interactables)
    	{
    		if(!(in.identify() == Interactable.InteractorTag.Player))
    			in.update(map, delta);
    	}
    	/* Update player */
    	player.update(map, dir_x, dir_y, delta, attack, talk);
    	
    	/* Check for interactions */
    	interactions();
    	
    	/* Update camera */
        cam.update();
       
        return; 
    }
    
    
    /** Checks for interactions between interactables and calls 
     * action on them
     */
    public void interactions()
    {
    	/* Check for null */
    	if(interactables == null)
    		return;
   
    	 for (Interactable in : interactables)
    	 {
    
    	     for (Interactable other : interactables)
    	     {
    	    	 if(other == null || in == null || other == in)
    	    	 {
    	    		 continue;
    	    	 }
    	    	 
    	    	 /* Don't interact if they are of the same type */
                if (other.identify() != in.identify() &&
	                       in.isWithinRange(other))
                {
                	
	                    in.action(other);
                }
                
    	     }
    	 	
    	}
    }

    /** Render the entire screen, so it reflects the current game state.
     * @param g The Slick graphics object, used for drawing.
     * @return void.
     */
    public void render(Graphics g)
    throws SlickException
    {
    	/* Finding screen width and height in tiles. */
    	/* + 2 because we want one extra tile on each side of the screen */
    	int screen_width = (int)(Constant.screenwidth/map.getTileWidth()) + extra_tiles;
    	int screen_height = (int)(Constant.screenheight/map.getTileWidth()) + extra_tiles;
    	
    	/* Finding coordinates of tile to start at. */
    	int start_tile_x = (int)(this.cam.getMinX()/map.getTileWidth()); 
    	int start_tile_y = (int)(this.cam.getMinY()/map.getTileHeight()); 
    	
    	/* Finding coordinates of pixels we should offset by. */
    	int start_pixel_x = (int)(this.cam.getMinX()%map.getTileWidth());
    	int start_pixel_y  = (int)(this.cam.getMinY()%map.getTileHeight());
    	
    	/* Rendering map and player. */
    	map.render(-start_pixel_x, -start_pixel_y, start_tile_x, start_tile_y, screen_width, screen_height);
    	g.translate(-(float)cam.getMinX(), -(float)cam.getMinY());
    	//player.render(g);
    	for(Interactable in: interactables)
    	{
    		in.render(g);
    	}
    	
        renderPanel(g);
    }
    
    /**
     * THIS CODE WAS NOT WRITTEN BY SHREYASH PATODIA, IT WAS PROVIDED TO 
     * US. 
     * Renders the player's status panel. (taken as-is from renderpanel.txt with only minor changes)
     *
     * @param g The current Slick graphics context.
     */
    public void renderPanel(Graphics g)
    {
        // Panel colours
        Color LABEL = new Color(0.9f, 0.9f, 0.4f);          // Gold
        Color VALUE = new Color(1.0f, 1.0f, 1.0f);          // White
        Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);   // Black, transp
        Color BAR = new Color(0.8f, 0.0f, 0.0f, 0.8f);      // Red, transp

        // Variables for layout
        String text;                // Text to display
        float text_x, text_y;         // Coordinates to draw text
        float bar_x, bar_y;           // Coordinates to draw rectangles
        float bar_width, bar_height;  // Size of rectangle to draw
        float hp_bar_width;           // Size of red (HP) rectangle
        float inv_x, inv_y;           // Coordinates to draw inventory item

        float health_percent;       // Player's health, as a percentage
        
        // Panel background image
        player.getPlayerPanel().draw(cam.getMinX(), cam.getMinY() + Constant.screenheight - Constant.PANEL_HEIGHT);

        // Display the player's health
        text_x = cam.getMinX() + 15;
        text_y = cam.getMinY() + Constant.screenheight - Constant.PANEL_HEIGHT + 25;
        g.setColor(LABEL);
        g.drawString("Health:", text_x, text_y);
        text = player.getHP() + "/" + player.getMaxHP();                                 // TODO: HP / Max-HP

        bar_x = cam.getMinX() + 90;
        bar_y = cam.getMinY() + Constant.screenheight - Constant.PANEL_HEIGHT + 20;
        bar_width = 90;
        bar_height = 30;
        health_percent = player.getHP()/(float)player.getMaxHP();                        // TODO: HP / Max-HP
        hp_bar_width = (bar_width * health_percent);
        text_x = bar_x + (bar_width - g.getFont().getWidth(text)) / 2;
        
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);
        
        g.setColor(BAR);
        g.fillRect(bar_x, bar_y, hp_bar_width, bar_height);
        
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);

        // Display the player's damage and coolDown
        text_x = cam.getMinX() + 200;
        g.setColor(LABEL);
        g.drawString("Damage:", text_x, text_y);
        text_x += 80;
        text = Integer.toString(player.getMaxDamage());               // TODO: Damage
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);
        text_x += 40;
        g.setColor(LABEL);
        g.drawString("Rate:", text_x, text_y);
        text_x += 55;
        text = Integer.toString(player.getMaxCoolDown());                                    // TODO: Cooldown
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);

        /*Display the player's inventory*/
        g.setColor(LABEL);
        g.drawString("Items:", cam.getMinX() + 420, text_y);
        bar_x = cam.getMinX() + 490;
        bar_y = cam.getMinY() + Constant.screenheight - Constant.PANEL_HEIGHT + 10;
        bar_width = 288;
        bar_height = bar_height + 20;
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);

        inv_x = cam.getMinX() + 490;
        inv_y = cam.getMinY() + Constant.screenheight - Constant.PANEL_HEIGHT
            + ((Constant.PANEL_HEIGHT  - 72) / 2);
        if(player.getItems() != null)
        {
        	for(Item item : player.getItems())
        	{
       
        		item.setPos(33 + inv_x, 33 + inv_y);
        		item.render(g);
        		inv_x += 72;
        	}
        }
    }
}
    


