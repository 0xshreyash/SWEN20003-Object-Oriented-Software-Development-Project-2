/* SWEN20003 Object Oriented Software Development 
 * RPG Game Engine
 * Author: <Shreyassh Patodia> <spatodia>
 * Student Number : 767336
 * Email: spatodia@student.unimelb.edu.au
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;


public interface Interactable 
{	

	/** Define all the methods dicated by this interface
	 */
	float collideRange = Constant.COLLIDE_RANGE;
    enum InteractorTag {Player, MonsterAggressive, MonsterPassive, Item, Villager};
    
	public abstract void action(Interactable other);
	public abstract boolean isWithinRange(Interactable other);
	public abstract boolean isSame(Object other);
	
	public abstract void update(Map map, float dir_x, float dir_y, int delta, int attack, int talk);
	public abstract void update(Map map, int delta);
	
	public abstract void render(Graphics g);
	
	public abstract Vector2f getPos();
	
	public abstract boolean isActive();
	
	public abstract InteractorTag identify();
}
