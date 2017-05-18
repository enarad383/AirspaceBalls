package gameplayObjects;

import functionality.Game;
import processing.core.PApplet;

/**Represents a cannon that can shoot projectiles.
 * 
 * @author enarad383
 *
 */
public class Cannon extends Planet{

	private double aimAngle;
	private double power;
	
	/**Represents a cannon object that can shoot projectiles.
	 * 
	 * @param radius The height at which it will orbit.
	 * @param angle The angle at which it is orbiting
	 * @param g The game that the proojecile uses for calculations.
	 * @param aimAngle The angle at which the canon is aiming.
	 */
	public Cannon(double radius, double angle, Game g, double aimAngle) {
		super(radius, angle, g, 1, 10);
		this.aimAngle = aimAngle;
		power = 3;
	}
	
	/** Aims the cannon.
	 * 
	 * @param direction The direction in which to aim.
	 */
	public void aim(boolean direction){
		if (direction){
			aimAngle += 0.05;
		}
		else{
			aimAngle -= 0.05;
		}
	}
	
	/** Changes the power of the cannon.
	 * 
	 * @param direction Whether to increase or decrease the power.
	 */
	public void changePower(boolean direction){
		if (direction){
			power += 0.1;
		}
		else{
			power -= 0.1;
		}
	}
	
	/**
	 * 
	 * @return The angle at which the cannon is aiming.
	 */
	public double getAimAngle(){
		return aimAngle;
	}
	
	/**
	 * 
	 * @return How powerful the cannon will shoot.
	 */
	public double getPower(){
		return power;
	}
	
	/**Moves the cannon along its orbit.
	 * 
	 */
	public void orbit(){
		aimAngle += getOrbVel();
		super.orbit();
	}
	
	public void draw(PApplet p){
		p.ellipseMode(p.CENTER);
		p.stroke(254);
		p.strokeWeight(1);
		p.fill(50,50,254);
		p.ellipse((float)(x), (float)(y), (float)size, (float)size);
		double l = 20;
		double w = 3;	
		p.pushMatrix();
		p.translate((float)x, (float)y);
		p.rotate((float)aimAngle);
		p.rect((float)l/2, -(float)w/2, (float)l, (float)w);
		p.popMatrix();
		p.stroke(0);
		
	}

}
