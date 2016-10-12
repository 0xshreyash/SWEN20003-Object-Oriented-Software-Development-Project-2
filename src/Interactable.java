// Add comments

import org.newdawn.slick.Graphics;


public interface Interactable 
{	
	//public abstract float distance(float x2, float y2);
	
	public abstract void action(Interactable other);
	
	public abstract boolean isInteractor(Interactable other);
	
	public abstract Class<? extends Entity> getTag();
	
	public abstract void update(Map map, float dir_x, float dir_y, int delta);
	
	public abstract void render(Graphics g, float cam_minX, float cam_minY);
}
