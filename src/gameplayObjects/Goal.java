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
	
	/**Moves the goal and checks if it's been hit.
	 * 
	 */
	public void orbit(){
		super.orbit();
		for (Projectile proj: super.game.getProjectiles()){
			if (distanceTo(proj)<this.size){
				isHit = true;
				game.setGoaled(true);
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
		p.fill(50,255,50);
		if (isHit){
			p.fill(0);
		}
		p.ellipse((float)(x), (float)(y), (float)size, (float)size);
	}

}
