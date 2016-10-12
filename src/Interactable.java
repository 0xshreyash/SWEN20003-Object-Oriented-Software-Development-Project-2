// Add comments

import org.newdawn.slick.Graphics;


public interface Interactable 
{	
	public abstract boolean withinRange(Interactable other);
	
	public abstract void action(Interactable other);
	
	public abstract boolean isInteractor(Interactable other);
	
	public abstract Enum<?>[] getTag();
	
	public abstract void update(Map map, int dir_x, int dir_y, int delta);
	
	public abstract void render(Graphics g, float cam_minX, float cam_minY);
}
