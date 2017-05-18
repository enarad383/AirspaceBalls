package gameplayObjects;

import functionality.Game;
import processing.core.PApplet;

/**Represents the target planet.
 * 
 * @author enarad383
 *
 */
public class Goal extends Planet{
	
	private boolean isHit;

	/**Creates a goal.
	 * 
	 * @param radius 
	 * @param angle
	 * @param g
	 * @param grav
	 * @param size
	 */
	public Goal(double radius, double angle, Game g, double grav, double size) {
		super(radius, angle, g, grav, size);
		// TODO Auto-generated constructor stub
		isHit = false;
	}
	
	public void orbit(){
		super.orbit();
		for (Projectile proj: super.game.getProjectiles()){
			if (distanceTo(proj)<this.size+15){
				isHit = true;
			}
		}
	}
	
	/**
	 * 
	 * @return Whether or not the target has been hit.
	 */
	public boolean isHit(){
		return isHit();
	}
	
	public void draw(PApplet p){
		p.ellipseMode(p.CENTER);
		p.fill(100,255,100);
		p.ellipse((float)(x), (float)(y), (float)size, (float)size);
	}

}
