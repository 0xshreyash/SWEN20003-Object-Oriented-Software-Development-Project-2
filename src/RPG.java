/* SWEN20003 Object Oriented Software Development  
 * RPG Game Engine
 * Author: Matt Giuca <mgiuca>
 */

import org.newdawn.slick.AppGameContainer; 
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/** Main class for the Role-Playing Game engine.
 * Handles initialization, input and rendering.
 */
public class RPG extends BasicGame
{
    
	/**************** Attributes *********************/
	
    /* Things that will be common to all of the game */
   
    /** Screen width, in pixels. */
    public static final int screenwidth = 800;
    
    /** Screen height, in pixels. */
    public static final int screenheight = 600;
    
    /** Game width, in pixels. */
    public static final int gamewidth = 6912;
    
    /** Game height, in pixels. */
    public static final int gameheight = 6912;
    
    /** Minimum coordinates on the map. */
    /** Min x coordinate on the map. */
    public static final int min_X = 0; 
    
    /** Min y coordinate on the map. */
    public static final int min_Y = 0;
    
    /** Path to assets folder. */
    public static final String ASSETS = "/assets/";
    
    /** Path to image of player from inside the assets folder. */
    public static final String PLAYER_IMG = "/assets/units/player.png";
    
    /** Path to image of tiles from inside the assets folder. */
    public static final String TILES_IMG = "/assets/tiles.png"; 
    
    /** Path to map.tmx from inside the assets folder. */
    public static final String MAP = "/assets/map.tmx";
    
    /* Other attributes. */
    private World world;
    
    /***************** Methods ***********************/
    
    /** Create a new RPG object. */
    public RPG()
    {
        super("RPG Game Engine");
    }

    /** Initialize the game state.
     * @param gc The Slick game container object.
     * @return void.
     */
    @Override
    public void init(GameContainer gc)
    throws SlickException
    {
        world = new World();
    }

    /** Update the game state for a frame.
     * @param gc The Slick game container object.
     * @param delta Time passed since last frame (milliseconds).
     * @return void. 
     */
    @Override
    public void update(GameContainer gc, int delta)
    throws SlickException
    {
        // Get data about the current input (keyboard state).
        Input input = gc.getInput();

        // Update the player's movement direction based on keyboard presses.
        double dir_x = 0;
        double dir_y = 0;
        if (input.isKeyDown(Input.KEY_DOWN))
            dir_y += 1;
        if (input.isKeyDown(Input.KEY_UP))
            dir_y -= 1;
        if (input.isKeyDown(Input.KEY_LEFT))
            dir_x -= 1;
        if (input.isKeyDown(Input.KEY_RIGHT))
            dir_x += 1;

        // Let World.update decide what to do with this data.
        world.update(dir_x, dir_y, delta);
    }

    /** Render the entire screen, so it reflects the current game state.
     * @param gc The Slick game container object.
     * @param g The Slick graphics object, used for drawing.
     * @return void.
     */
    public void render(GameContainer gc, Graphics g)
    throws SlickException
    {
        // Let World.render handle the rendering.
        world.render(g);
    }

    /** Start-up method. Creates the game and runs it.
     * @param args Command-line arguments (ignored).
     * @return void.
     */
    public static void main(String[] args)
    throws SlickException
    {
        AppGameContainer app = new AppGameContainer(new RPG());
        // setShowFPS(true), to show frames-per-second.
        app.setShowFPS(true);
        app.setDisplayMode(screenwidth, screenheight, false);
        app.start();
    }
}
