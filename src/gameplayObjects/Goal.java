package gameplayObjects;

import functionality.Game;
import processing.core.PApplet;

/**Represents the target planet.
 * 
 * @author enarad383
 *
 */
public class Goal extends Planet{

	public Goal(double radius, double angle, Game g, double grav, double size) {
		super(radius, angle, g, grav, size);
		// TODO Auto-generated constructor stub
	}
	
	public void draw(PApplet p){
		p.ellipseMode(p.CENTER);
		p.fill(100,255,100);
		p.ellipse((float)(x), (float)(y), (float)size, (float)size);
	}

}
